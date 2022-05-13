package com.santiago.quizzes.quizzes.dtos

data class QuizResultDto (
    val idQuizResult: String,
    val idQuiz: String,
    val result: QuizResultItemDto
)

data class QuizResultItemDto (
    val title: String,
    val descriptionResult: String,
    val result: String,
    val image: String
)