package com.santiago.quizzes.quizzes.services

import com.santiago.quizzes.quizzes.documents.QuizItem
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface QuizHomeService {

    fun findByIdQuizHome(idQuizHome: String): QuizItem?

    fun save(quizHome: QuizItem): QuizItem

    fun findAll(pageRequest: PageRequest): Page<QuizItem>
}