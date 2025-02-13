package com.Project.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.quiz_service.model.QuizQuestions;
import com.Project.quiz_service.model.Response;


//this interface is communication between two MICROSERVICES and feign is used to search the registry here it is searching for QUESTION-SERVICE
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	@GetMapping("question/generate")
	public ResponseEntity<List<String>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions);
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuizQuestions>> getQuestionsFromId(@RequestBody List<String> questionIds);
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
