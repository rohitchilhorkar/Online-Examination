package com.pratiti.model;

import java.util.List;

public class SubjectDto {
	private String subjectName;
	private int subjectNoOfQuestions;
	private List<QuestionDto> questions;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectNoOfQuestions() {
		return subjectNoOfQuestions;
	}
	public void setSubjectNoOfQuestions(int subjectNoOfQuestions) {
		this.subjectNoOfQuestions = subjectNoOfQuestions;
	}
	public List<QuestionDto> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}

	

}
