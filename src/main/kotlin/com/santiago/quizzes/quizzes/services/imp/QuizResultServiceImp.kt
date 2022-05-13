package com.santiago.quizzes.quizzes.services.imp

import com.santiago.quizzes.quizzes.documents.QuizResult
import com.santiago.quizzes.quizzes.repositories.QuizResultRepository
import com.santiago.quizzes.quizzes.services.QuizResultService
import org.springframework.stereotype.Service

@Service
class QuizResultServiceImp(private val quizResultRepository: QuizResultRepository) : QuizResultService {
    override fun findByIdQuiz(idQuiz: String): QuizResult = quizResultRepository.findByIdQuiz(idQuiz)
}