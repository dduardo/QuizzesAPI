package com.santiago.quizzes.quizzes.services.imp

import com.santiago.quizzes.quizzes.documents.QuizHome
import com.santiago.quizzes.quizzes.documents.QuizItem
import com.santiago.quizzes.quizzes.repositories.QuizHomeRepository
import com.santiago.quizzes.quizzes.services.QuizHomeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class QuizHomeServiceImp(private val quizHomeRepository: QuizHomeRepository) : QuizHomeService {
    override fun findByIdQuizHome(idQuizHome: String): QuizItem? = quizHomeRepository.findByIdQuizHome(idQuizHome)

    override fun save(quizItem: QuizItem): QuizItem = quizHomeRepository.save(quizItem)

    override fun findAll(pageRequest: PageRequest): Page<QuizItem> =
        quizHomeRepository.findAll(pageRequest)
}