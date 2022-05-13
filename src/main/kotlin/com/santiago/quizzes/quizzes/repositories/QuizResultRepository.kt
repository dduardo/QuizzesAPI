package com.santiago.quizzes.quizzes.repositories

import com.santiago.quizzes.quizzes.documents.Quiz
import com.santiago.quizzes.quizzes.documents.QuizResult
import org.springframework.data.mongodb.repository.MongoRepository

interface QuizResultRepository : MongoRepository<QuizResult, String> {

    fun findByIdQuiz(idQuiz: String): QuizResult
}