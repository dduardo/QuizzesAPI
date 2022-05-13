package com.santiago.quizzes.quizzes.documents

import com.fasterxml.jackson.annotation.JsonProperty
import com.santiago.quizzes.quizzes.dtos.QuizItemDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class QuizHome(
    @JsonProperty("quiz_List")
    val quizList: List<QuizItem>
)

@Document
data class QuizItem(
    @Id val idQuizHome: String? = null,
    val group: String,
    var image: String,
    val headline: String,
    val description: String
)

fun QuizItem.toQuizItemDto() = QuizItemDto(
    image = this.image.toString(),
    idQuizHome = this.idQuizHome,
    group = this.group,
    description = this.description,
    headline = this.headline
)