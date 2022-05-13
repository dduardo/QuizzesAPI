package com.santiago.quizzes.quizzes.repositories

import com.santiago.quizzes.quizzes.documents.Quiz
import com.santiago.quizzes.quizzes.documents.QuizHome
import org.springframework.data.mongodb.repository.MongoRepository

interface QuizRepository : MongoRepository<Quiz, String> {
    fun findByIdQuizHome(idQuizHome: String): Quiz?
}