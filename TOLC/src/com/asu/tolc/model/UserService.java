package com.asu.tolc.model;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asu.tolc.entity.UserEntity;
import com.asu.tolc.utilities.SessionFactoryUtil;

public class UserService {
	
	private String userName;
	private String password;
	private String email;
	private String state;
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
	public UserService(String userName, String password, String email,
			String state, String notifications) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.state = state;
		this.notifications=notifications;
	}
	public UserService(String userName, String password ) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public void register() throws Exception {
		UserEntity userEntity;
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx=session.beginTransaction();
			userEntity = (UserEntity)session.get(UserEntity.class, userName);
			if(userEntity != null)
				throw new Exception("User already exists !!");
			
			userEntity = new UserEntity();
			userEntity.setUserName(userName);
			userEntity.setPassword(password);
			userEntity.setEmail(email);
			userEntity.setNoOfPosts(0);
			userEntity.setNoOfReplies(0);
			userEntity.setState(state);
			userEntity.setNotifications(notifications);
			if(notifications.isEmpty())
				userEntity.setNotifications("N");
			
			session.save(userEntity);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
		
	}
	
	public UserEntity login() throws Exception
	{
		UserEntity userEntity;
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
	
		try
		{
			session.beginTransaction();
			userEntity = (UserEntity)session.get(UserEntity.class, userName);
			if(userEntity == null)
				throw new Exception("User invalid!!");
			if(!userEntity.getPassword().equals(password))
				throw new Exception("Invalid user name, password combination");
		}
		finally
		{
			session.close();
		}
		
		return userEntity;
	}

}
