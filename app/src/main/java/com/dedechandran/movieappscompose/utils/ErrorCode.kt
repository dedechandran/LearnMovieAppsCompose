package com.dedechandran.movieappscompose.utils

object ErrorCode {
    val ERROR_500 = ErrorData(code = 500, "Internal Server Error")
}

data class ErrorData(
    val code: Int,
    val message: String
)
