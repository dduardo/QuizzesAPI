package com.santiago.quizzes.quizzes.controllers


import com.santiago.quizzes.quizzes.documents.Quiz
import com.santiago.quizzes.quizzes.dtos.QuizRequestDto
import com.santiago.quizzes.quizzes.response.Response
import com.santiago.quizzes.quizzes.services.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/quiz")
class QuizController(val quizService: QuizService) {

    @PostMapping
    fun quizzes(@RequestBody quizRequestDto: QuizRequestDto,
                result: BindingResult): ResponseEntity<Response<Quiz>> {
        print(quizRequestDto)
        val response: Response<Quiz> = Response<Quiz>()
        val quizItem: Quiz? = quizRequestDto.idQuizHome?.let { quizService.findByIdQuizHome(it) }
        
        response.data = quizItem
        return ResponseEntity.ok(response)
    }
}
