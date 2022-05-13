package com.santiago.quizzes.quizzes.services

import com.santiago.quizzes.quizzes.documents.QuizResult

interface QuizResultService {
    fun findByIdQuiz(idQuiz: String): QuizResult
}