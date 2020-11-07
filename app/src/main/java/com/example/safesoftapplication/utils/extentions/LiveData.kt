package com.example.safesoftapplication.utils.extentions

import androidx.lifecycle.MutableLiveData
import com.example.safesoftapplication.utils.Resource
import com.example.safesoftapplication.utils.ResourceState


fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T? = null) =
    postValue(Resource(ResourceState.SUCCESS, data))

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(Resource(ResourceState.LOADING, value?.data))

fun <T> MutableLiveData<Resource<T>>.setError(
    message: String? = null, exception: Throwable? = null, messageId: Int? = null
) = postValue(Resource(ResourceState.ERROR, value?.data, message, messageId, exception))