package com.dedechandran.movieappscompose.network

import com.google.gson.annotations.SerializedName
import java.io.IOException

typealias GenericResponse<S> = NetworkResponse<S, GenericApiError>

sealed class NetworkResponse<out T : Any, out U : Any> {

    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()

    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()

    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()
}

data class GenericApiError(
    @SerializedName("status_message")
    val statusMessage: String,

    @SerializedName("status_code")
    val statusCode: Int
)
