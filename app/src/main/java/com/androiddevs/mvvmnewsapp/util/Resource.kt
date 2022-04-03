package com.androiddevs.mvvmnewsapp.util

//this class wrap around network resources, recommended by google
//it's generic class, it differentiate between successful and error responses
//help in loading state, like progressbar, request is processing, etc

//sealed is like abstract but we define which class is allowed to be inherit from that resource class
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}