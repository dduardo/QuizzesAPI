package com.santiago.quizzes.quizzes.documents

import com.santiago.quizzes.quizzes.dtos.QuizItemDto
import com.santiago.quizzes.quizzes.dtos.QuizResultDto
import com.santiago.quizzes.quizzes.dtos.QuizResultItemDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class QuizResult (
    @Id val idQuizResult: String,
    val idQuiz: String,
    val result: ResultItemQuiz
)

@Document
data class ResultItemQuiz (
    val title: String,
    val descriptionResult: String,
    val result0: String,
    val image0: String,
    val result1: String,
    val image1: String,
    val result2: String,
    val image2: String
)

fun QuizResult.toQuizResultDto(result: Pair<String, String>) = QuizResultDto(
    idQuizResult = this.idQuizResult,
    idQuiz = this.idQuiz,
    result = QuizResultItemDto(title = this.result.title,
        descriptionResult = this.result.descriptionResult,
        result = result.first,
        image = result.second)
)