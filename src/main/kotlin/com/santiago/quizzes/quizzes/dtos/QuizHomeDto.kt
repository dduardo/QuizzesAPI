package com.santiago.quizzes.quizzes.dtos

import org.springframework.data.domain.Page

data class QuizHomeDto(
    val quizList: Page<QuizItemDto> = Page.empty()
)

data class QuizItemDto (
    val idQuizHome: String? = "",
    val group: String = "",
    val image: String = "",
    val headline: String = "",
    val description: String = ""
)
