package com.santiago.quizzes.quizzes.services

import com.santiago.quizzes.quizzes.documents.Quiz


interface QuizService {

    fun findByIdQuizHome(idQuizHome: String): Quiz?

    fun save(quiz: Quiz): Quiz
}