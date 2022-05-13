package com.santiago.quizzes.quizzes.response

data class Response<T> (
    val errors: ArrayList<String>? = null,
    var data: T? = null
)