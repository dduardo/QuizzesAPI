package com.santiago.quizzes.quizzes.controllers

import com.santiago.quizzes.quizzes.documents.Quiz
import com.santiago.quizzes.quizzes.documents.QuizResult
import com.santiago.quizzes.quizzes.documents.toQuizResultDto
import com.santiago.quizzes.quizzes.dtos.QuizRequestDto
import com.santiago.quizzes.quizzes.dtos.QuizRequestResultDto
import com.santiago.quizzes.quizzes.dtos.QuizResultDto
import com.santiago.quizzes.quizzes.dtos.QuizResultItemDto
import com.santiago.quizzes.quizzes.response.Response
import com.santiago.quizzes.quizzes.services.QuizResultService
import com.santiago.quizzes.quizzes.services.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/quizResult")
class QuizResultController(val quizResultService: QuizResultService) {

    @PostMapping
    fun quizzesResult(@RequestBody quizRequestResultDto: QuizRequestResultDto,
                      result: BindingResult
    ): ResponseEntity<Response<QuizResultDto>> {
        val response = Response<QuizResultDto>()
        val quizResult: QuizResult? = quizRequestResultDto.idQuiz?.let { quizResultService.findByIdQuiz(it) }

        print("quizRequestResultDto: " + quizRequestResultDto)
        validateResult(quizResult, result)

        response.data = quizResult?.toQuizResultDto(validateResult(quizRequestResultDto, quizResult))
        return ResponseEntity.ok(response)
    }

    private fun validateResult(quizResult: QuizResult?,
                               result: BindingResult) {
        if (quizResult != null) {
            result.addError(ObjectError("quizResult", ""))
        }
    }

    private fun validateResult(quizRequestResultDto: QuizRequestResultDto,
                               quizResult: QuizResult): Pair<String, String> {
        val model = quizResult?.result?.let { it }

        if (quizRequestResultDto.resultQuizValue in 0..40)
            return Pair(model.result0, model.image0)
        if (quizRequestResultDto.resultQuizValue in 41..80)
            return Pair(model.result1, model.image1)
        if (quizRequestResultDto.resultQuizValue in 81..120)
            return Pair(model.result2, model.image2)

        return Pair("", "")
    }
}
