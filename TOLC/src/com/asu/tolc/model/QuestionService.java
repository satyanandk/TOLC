package com.asu.tolc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





import org.hibernate.Query;
//import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asu.tolc.entity.QuestionEntity;
import com.asu.tolc.entity.UserEntity;
import com.asu.tolc.utilities.MailUtility;
import com.asu.tolc.utilities.SessionFactoryUtil;

public class QuestionService {
	private String userName;
	private String questionTitle;
	private String question;
	private String state;
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
	public QuestionService(String userName, String questionTitle,
			String question, String state) {
		super();
		this.userName = userName;
		this.questionTitle = questionTitle;
		this.question = question;
		this.state = state;
	}
	 
	public QuestionService() {
		// TODO Auto-generated constructor stub
	}
	public void postQuestion() throws Exception
	{
		QuestionEntity questionEntity ;
		Transaction tx=null;
		UserEntity userEntity;
		org.hibernate.Session session = SessionFactoryUtil.getSessionFactory().openSession();
		try
		{
			tx=session.beginTransaction();
			questionEntity = new QuestionEntity();
			questionEntity.setState(state);
			questionEntity.setQuestion(question);
			questionEntity.setQuestionTitle(questionTitle);
			questionEntity.setUserName(userName);
			
			session.save(questionEntity);
			userEntity = (UserEntity)session.get(UserEntity.class, userName);
			if(userEntity == null)
				throw new Exception("User invalid!!");
			
			int noOfPosts = userEntity.getNoOfPosts();
			userEntity.setNoOfPosts(noOfPosts+1);
			
			session.update(userEntity);
			
			tx.commit();
			
			sendMail(userName,question, questionTitle);
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
	private String formMessage(String userName, String question, String questionTitle)
	{
		String text = "Dear member,"
				+ "\n\n"+questionTitle+"\n\n"+question+"\n\nRegards,\n"+userName;
		return text;
	}

	private void viaGmail(String userName, String question,
			String questionTitle,List<String> emailList) throws Exception
	{
		final String username = "gopinathinduja@gmail.com";
		final String password = "letmein!!";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		int i=0;
		InternetAddress[] recipientAddress = new InternetAddress[emailList.size()];
		for(String email:emailList)
		{
			System.out.println("email = "+email);
			recipientAddress[i++]=new InternetAddress(email);
		}
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gopinathinduja@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				recipientAddress);
			message.setSubject(userName+" asked you a question");
			message.setText("Dear member,"
				+ "\n\n"+questionTitle+"\n\n"+question+"\n\nRegards,\n"+userName);
 
			
			Transport.send(message);
 
	}
	private void sendMail(String userName, String question,
			String questionTitle) throws Exception{
		// TODO Auto-generated method stub
		Transaction tx=null;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		ArrayList<String> emailList = new ArrayList<String>();
		
		try
		{
			tx=hibSession.beginTransaction();
			String hql="FROM UserEntity U WHERE U.state = '"+state+"' AND U.notifications='Y'";
			Query query = hibSession.createQuery(hql);
			List results = query.list();
			
			for (Iterator iterator = 
					results.iterator(); iterator.hasNext();){
				UserEntity userEntity = (UserEntity) iterator.next();
				System.out.println("Email to :"+userEntity.getEmail());
				emailList.add(userEntity.getEmail());
				
			}	
			
			MailUtility.viaGmail(formMessage(userName,question,questionTitle),userName+" asked you a question" , emailList);
			//viaGmail(userName, question, questionTitle, emailList);
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			hibSession.close();
		}
		
	}
	public QuestionEntity getQuestion(int questionNum) throws Exception {
		QuestionEntity qEntity;
		org.hibernate.Session session = SessionFactoryUtil.getSessionFactory().openSession();
	
		try
		{
			session.beginTransaction();
			qEntity = (QuestionEntity)session.get(QuestionEntity.class, questionNum);
			if(qEntity == null)
				throw new Exception("Question invalid!!");
		}
		finally
		{
			session.close();
		}
		
		return qEntity;
	}
	public List<QuestionEntity> getQuestions() throws Exception
	{
		Transaction tx=null;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		List<QuestionEntity> questionEntityList = new ArrayList<QuestionEntity>();
		
		try
		{
			tx=hibSession.beginTransaction();
			String hql="FROM QuestionEntity ";
			Query query = hibSession.createQuery(hql);
			List results = query.list();
			
			for (Iterator iterator = 
					results.iterator(); iterator.hasNext();){
				QuestionEntity questionEntity = (QuestionEntity) iterator.next();
				questionEntityList.add(questionEntity);
			}	
		}
		finally
		{
			hibSession.close();
		}
		
		return questionEntityList;
	}
}
