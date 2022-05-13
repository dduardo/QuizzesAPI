package com.santiago.quizzes.quizzes.controllers

import com.santiago.quizzes.quizzes.documents.QuizItem
import com.santiago.quizzes.quizzes.dtos.QuizItemDto
import com.santiago.quizzes.quizzes.response.Response
import com.santiago.quizzes.quizzes.services.QuizHomeService
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/quizHome")
class QuizHomeController(val quizHomeService: QuizHomeService) {

    @Value("\${pagination.qty_per_page}")
    val qtdPag = 20

    @PostMapping
    fun listQuizHome(
        @RequestParam(value = "pag", defaultValue = "0") pag: Int,
        @RequestParam(value = "ord", defaultValue = "id") ord: String,
        @RequestParam(value = "dir", defaultValue = "DESC") dir: String
    ):
            ResponseEntity<Response<Page<QuizItemDto>>> {

        val response: Response<Page<QuizItemDto>> = Response<Page<QuizItemDto>>()

        val pageRequest: PageRequest = PageRequest.of(pag, qtdPag, Sort.Direction.valueOf(dir), ord)
        val quizItems: Page<QuizItem> = quizHomeService.findAll(pageRequest)
        val quizItemDto: Page<QuizItemDto> = quizHomeDtoConverter(quizItems)

        response.data = quizItemDto
        return ResponseEntity.ok(response)
    }

    private fun quizHomeDtoConverter(quizItems: Page<QuizItem>) = quizItems.map { quizItem ->
        QuizItemDto(
            quizItem.idQuizHome,
            quizItem.group,
            quizItem.image,
            quizItem.headline,
            quizItem.description
        )
    }
}