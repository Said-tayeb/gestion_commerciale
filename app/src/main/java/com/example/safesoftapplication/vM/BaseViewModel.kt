package com.example.safesoftapplication.vM

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.safesoftapplication.utils.Resource
import com.example.safesoftapplication.utils.extentions.setError
import com.example.safesoftapplication.utils.extentions.setLoading
import com.example.safesoftapplication.utils.extentions.setSuccess
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract  class BaseViewModel : ViewModel() {

    private val TAG = BaseViewModel::class.simpleName

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

    protected fun <T> enqueue(useCase: Observable<T>, observedData: MutableLiveData<Resource<T>>) {
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

    protected fun <T> enqueue(useCase: Single<T>, observedData: MutableLiveData<Resource<T>>) {
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

    protected fun <T> enqueue(useCase: Completable, observedData: MutableLiveData<Resource<T>>) {
        val observable = useCase
            .doOnSubscribe { observedData.setLoading() }
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)


        disposables.add(
            observable.subscribe(
                {
                    Log.d(TAG, "enqueue: Completed With Success! ")
                    observedData.setSuccess()
                },
                { observedData.setError(exception = it) }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposables.isDisposed)
            disposables.dispose()
    }
}