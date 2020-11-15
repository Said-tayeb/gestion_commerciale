package com.example.safesoftapplication.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.safesoftapplication.utils.Resource
import com.example.safesoftapplication.utils.extentions.setError
import com.example.safesoftapplication.utils.extentions.setLoading
import com.example.safesoftapplication.utils.extentions.setSuccess
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseVM constructor(): ViewModel()  {

    private val subscribeOn: Scheduler = Schedulers.io()
    private val observeOn: Scheduler = AndroidSchedulers.mainThread()
    private val disposables: CompositeDisposable = CompositeDisposable()

    protected fun <T> enqueue(useCase: Flowable<T>, observedData: MutableLiveData<Resource<T>>) {
        val observable = useCase
            .doOnSubscribe { observedData.setLoading() }
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
        disposables.add(
            observable.subscribe(
                { observedData.setSuccess(it) },
                { observedData.setError(exception = it) }
            )
        )
    }
}