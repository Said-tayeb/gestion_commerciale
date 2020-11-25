package com.example.safesoftapplication.ui.generics

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.safesoftapplication.ui.generics.adapter.BaseFragmentAdapter
import com.example.safesoftapplication.utils.Resource
import com.example.safesoftapplication.utils.ResourceState
import java.io.IOException

abstract class BaseFragment : Fragment() {
    private val TAG = BaseFragment::class.simpleName

    protected var currentItemPosition: Int = -1

    protected val loading = ResourceState.LOADING
    protected val success = ResourceState.SUCCESS
    protected val error = ResourceState.ERROR

    protected lateinit var pagerAdapter: BaseFragmentAdapter
    protected lateinit var titles: Array<Int>
    protected lateinit var fragments: Array<Fragment>


    protected fun toast(@StringRes messageId: Int? = null, message: String? = null) {
        if (messageId != null)
            Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun <T> errorHandler(state: Resource<T>) {
        when {
            state.messageId != null -> toast(messageId = state.messageId)
            state.message != null -> {
                toast(message = state.message)
            }
            else -> {
                state.exception!!.printStackTrace()
            }
        }
    }

    protected open fun setUpViews() {}
    protected open fun setUpObservers() {}
    protected open fun setUp() {}


    override fun onResume() {
        super.onResume()
        setUp()
        setUpViews()
        setUpObservers()
    }

    fun isDataConnected(): Boolean {
        try {
            val process = Runtime.getRuntime().exec("ping -c 1 8.8.8.8")
            val returnVal = process.waitFor()
            return returnVal == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }
}