package com.Project.quiz_service.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quiz")
public class Quiz {
	@Id
	private String id;
	private String title;
	private List<String> questionsID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getQuestionsID() {
		return questionsID;
	}
	public void setQuestionsID(List<String> questionsID) {
		this.questionsID = questionsID;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questionsID=" + questionsID + "]";
	}
	
	
}
