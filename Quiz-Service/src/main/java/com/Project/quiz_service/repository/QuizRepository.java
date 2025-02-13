package com.Project.quiz_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Project.quiz_service.model.Quiz;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String>{
//	@Query(value = "{ '_id': ?0 }", fields = "{ 'questions': 1 }")
//    Optional<Quiz> findQuestionsByQuizId(String id);

}
