package com.asu.tolc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Notification")
public class NotificationEntity {
	@Id
	@GeneratedValue
	private int id;
	private int questionNum;
	private String subscriberEmailID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String getSubscriberEmailID() {
		return subscriberEmailID;
	}
	public void setSubscriberEmailID(String subscriberEmailID) {
		this.subscriberEmailID = subscriberEmailID;
	}
	

}
