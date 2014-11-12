package com.asu.tolc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DTLS")
public class UserEntity {

	@Id 
	@Column(name = "user_name",length = 10)
	private String userName;
	@Column(name = "password",length = 15)
	private String password;
	@Column(name = "email",length = 100)
	private String email;
	@Column(name = "state",length = 100)
	private String state;
	@Column(name = "no_of_posts")
	private int noOfPosts;
	@Column(name = "no_of_replies")
	private int noOfReplies;
	@Column(name = "notifications",length=1)
	private String notifications;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNoOfPosts() {
		return noOfPosts;
	}
	public void setNoOfPosts(int noOfPosts) {
		this.noOfPosts = noOfPosts;
	}
	public int getNoOfReplies() {
		return noOfReplies;
	}
	public void setNoOfReplies(int noOfReplies) {
		this.noOfReplies = noOfReplies;
	}
	public String getNotifications() {
		return notifications;
	}
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}
	
	
}
