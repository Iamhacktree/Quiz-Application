package com.Project.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.quiz_service.model.QuizDTO;
import com.Project.quiz_service.model.QuizQuestions;
import com.Project.quiz_service.model.Response;
import com.Project.quiz_service.service.QuizService;

@Controller
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	
	//input --> localhost:8080/quiz/create
	/*body
	 * {
    "category" : "JavaScript",
    "numQ" : 2,
    "title" : "JavaScript Quiz"
}
	 */
	//this will create quiz
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
		return quizService.createQuiz(quizDTO.getCategory(), quizDTO.getNumQ(), quizDTO.getTitle());
	}
	
	//this will get question for quiz
	//input --> localhost:8080/quiz/get/67ab31f30ab43b4ebc29c14e
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuizQuestions>> getQuiz(@PathVariable String id){
		return quizService.findQuestionsByQuizId(id);
	}
	//we have to pass quiz id and in body question id with response
	//input--> localhost:8080/quiz/submit/67ab31f30ab43b4ebc29c14e
	/*
	 * body
	 * [
    {
        "id" : "67a87ae9420e74cfb7d4a049",
        "response" : "Event loop handles asynchronous operations"
    },

    {
        "id" : "67a87453420e74cfb7d4a03d",
        "response" : "Callbacks"
    }
]
*/
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> calculateResult(@PathVariable String id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses);
	}
}
