package com.santiago.quizzes.quizzes.repositories

import org.springframework.data.domain.Pageable
import com.santiago.quizzes.quizzes.documents.QuizItem
import org.springframework.data.domain.Page
import org.springframework.data.mongodb.repository.MongoRepository

interface QuizHomeRepository : MongoRepository<QuizItem, String> {

    override fun findAllById(ids: MutableIterable<String>): MutableIterable<QuizItem>

    override fun findAll(pageable: Pageable) : Page<QuizItem>

    fun findByIdQuizHome(idQuizHome: String): QuizItem
}