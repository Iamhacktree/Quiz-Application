package com.Project.question_service.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.question_service.model.Question;
import com.Project.question_service.model.QuizQuestions;
import com.Project.question_service.model.Response;
import com.Project.question_service.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	public ResponseEntity<List<Question>> getAllQuestion() {
		return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<List<Question>> getByCategory(String category) {
		return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
	}
	
	public ResponseEntity<String> addQuestion(Question question) {
		questionRepository.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<String>> getQuestionsForQuiz(String categoryName, int numQuestions) {
		//getting only id's of questions because in quiz do not need whole data it only id and using that id it will fetch data
		List<String> questions = questionRepository.findRandomQuestionsByCategory(categoryName, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	
	public ResponseEntity<List<QuizQuestions>> getQuestionsFromId(List<String> questionIds) {
		List<QuizQuestions> quizQuestions = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		
		//here we got all the questions using questionsIds from question database
		for(String id : questionIds) {
			questions.add(questionRepository.findById(id).get());
		}
		
		for(Question question : questions ) {
			QuizQuestions qq = new QuizQuestions();
			qq.setTitle(question.getTitle());
			qq.setOption1(question.getOption1());
			qq.setOption2(question.getOption2());
			qq.setOption3(question.getOption3());
			qq.setOption4(question.getOption4());
			
			quizQuestions.add(qq);
		}
		return new ResponseEntity<>(quizQuestions, HttpStatus.OK);
	}

	
	public ResponseEntity<Integer> getSocre(List<Response> responses) {
		int right = 0;
		
		for(Response response : responses) {
			Question question = questionRepository.findById(response.getId()).get();//we have specified get here because it will return optional
			if(response.getResponse().equals(question.getRightAnswer())) {
				right++;
			}
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	} 
}
