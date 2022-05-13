package com.santiago.quizzes.quizzes.services.imp

import com.santiago.quizzes.quizzes.documents.Quiz
import com.santiago.quizzes.quizzes.repositories.QuizRepository
import com.santiago.quizzes.quizzes.services.QuizService
import org.springframework.stereotype.Service

@Service
class QuizServiceImp(private val quizRepository: QuizRepository) : QuizService {
    override fun findByIdQuizHome(idQuizHome: String): Quiz? = quizRepository.findByIdQuizHome(idQuizHome)

    override fun save(quiz: Quiz): Quiz = quizRepository.save(quiz)
}