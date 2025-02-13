package com.Project.quiz_service.model;


//We will pass question id and their response of question 
public class Response {
	private String id;
	private String response;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + "]";
	}
}
