package com.asu.tolc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_DTLS")
public class QuestionEntity {

	@Id 
	@GeneratedValue
	@Column(name = "question_no")
	private int questionNo;
	@Column(name = "user_name",length = 10)
	private String userName;
	@Column(name = "question_title")
	private String questionTitle;
	@Column(name = "question", length=1000)
	private String question;
	@Column(name = "state",length = 10)
	private String state;
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
