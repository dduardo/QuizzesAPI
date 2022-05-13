package com.santiago.quizzes.quizzes.documents

import com.fasterxml.jackson.annotation.JsonProperty
import com.santiago.quizzes.quizzes.dtos.QuizResultDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Quiz (
    @JsonProperty("id_quiz")
    @Id val idQuiz: String? = null,

    @JsonProperty("id_quiz_home")
    val idQuizHome: String,
    val description: Description,
    val questions: List<Question>
)

@Document
data class Description (
    val group: String,
    val image: String,
    val headline: String,
    val description: String
)

@Document
data class Question (
    @JsonProperty("id_question")
    @Id val idQuestion: String,
    val question: String,
    val answers: List<Answer>
)

@Document
data class Answer (
    val image: String,
    val option: String,
    val value: Long
)