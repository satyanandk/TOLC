package com.asu.tolc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.asu.tolc.entity.NotificationEntity;
import com.asu.tolc.entity.QuestionEntity;
import com.asu.tolc.entity.ReplyEntity;
import com.asu.tolc.entity.UserEntity;
import com.asu.tolc.utilities.MailUtility;
import com.asu.tolc.utilities.SessionFactoryUtil;

public class ReplyService {
	
	public List<ReplyEntity> getReplies(int questionNum) throws Exception {
		
		Transaction tx=null;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		List<ReplyEntity> replyEntityList = new ArrayList<ReplyEntity>();
		
		try
		{
			//tx=hibSession.beginTransaction();
			String hql="FROM ReplyEntity R WHERE R.questionNo = '"+questionNum+"'";
			Query query = hibSession.createQuery(hql);
			List results = query.list();
			
			for (Iterator iterator = 
					results.iterator(); iterator.hasNext();){
				ReplyEntity replyEntity = (ReplyEntity) iterator.next();
				replyEntityList.add(replyEntity);
			}	
		}
		finally
		{
			hibSession.close();
		}
		
		return replyEntityList;
		
	}
	public void subscribe(String userName, int questionNum)
	{
		Transaction tx=null;
		NotificationEntity nEntity;
		UserEntity userEntity;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		try
		{
			tx=hibSession.beginTransaction();
			userEntity = (UserEntity)hibSession.get(UserEntity.class, userName);
			if(userEntity == null)
				throw new Exception("User invalid!!");
			
			nEntity = new NotificationEntity();
			nEntity.setQuestionNum(questionNum);
			nEntity.setSubscriberEmailID(userEntity.getEmail());
			hibSession.save(nEntity);
			
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			hibSession.close();
		}
		
		
	}
	
	public void postReply(String userName, int questionNum, String reply, String category) throws Exception
	{
		Transaction tx=null;
		ReplyEntity replyEntity = new ReplyEntity();
		UserEntity userEntity;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		try
		{
			System.out.println("Entered Here");
			tx=hibSession.beginTransaction();
			replyEntity.setQuestionNo(questionNum);
			replyEntity.setRepliedBy(userName);
			replyEntity.setReply(reply);
			replyEntity.setCategory(category);
			
			hibSession.save(replyEntity);
			System.out.println("Entered Here1");
			userEntity = (UserEntity)hibSession.get(UserEntity.class, userName);
			if(userEntity == null)
				throw new Exception("User invalid!!");
			
			int noOfReplies = userEntity.getNoOfReplies();
			userEntity.setNoOfReplies(noOfReplies+1);
			
			hibSession.update(userEntity);
			System.out.println("Entered Here2");
			sendEmailNotificationsToSubscribers(questionNum,userName);
			System.out.println("Entered Here3");
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			hibSession.close();
		}
	}

	private String formMessage(String questionTitle, int questionNum)
	{
		String text = "Dear member,\nA new post has been done to the thread you subscribed currently on topic \n"
				+ "Topic : "+questionTitle+".\n Please"
				+ " follow the URL below to check the post\n www.tolc.com:8080/TOLC/OpenQuestionServlet1?questionNum="+questionNum+"";
		return text;
		
	}
	public void sendEmailNotificationsToSubscribers(int questionNum, String userName) throws Exception {
		// TODO Auto-generated method stub
		
		Transaction tx=null;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		List<String> nEntityEmailList = new ArrayList<String>();
		QuestionEntity qEntity;
		
		try
		{
			//tx=hibSession.beginTransaction();
			String hql="FROM NotificationEntity R WHERE R.questionNum = '"+questionNum+"'";
			Query query = hibSession.createQuery(hql);
			List results = query.list();
			if(results == null ||results.isEmpty())
				return;
			for (Iterator iterator = 
					results.iterator(); iterator.hasNext();){
				NotificationEntity nEntity = (NotificationEntity) iterator.next();
				nEntityEmailList.add(nEntity.getSubscriberEmailID());
			}	
			
			qEntity = (QuestionEntity)hibSession.get(QuestionEntity.class, questionNum);
			
			MailUtility.viaGmail(formMessage(qEntity.getQuestionTitle(),questionNum),
					"Notification: A new post on "+qEntity.getQuestionTitle(), nEntityEmailList);
			
		}
		finally
		{
			hibSession.close();
		}
	}
	
	public HashMap<String,Integer> createBadge(String userName)
	{
		HashMap<String,Integer> bMap = new HashMap<String,Integer>();
		
		Transaction tx=null;
		Integer eventCount=0;
		Integer foodCount=0;
		Integer landmarkCount=0;
		Integer travelCount=0;
		org.hibernate.Session hibSession = SessionFactoryUtil.getSessionFactory().openSession();
		
		try
		{
			//tx=hibSession.beginTransaction();
			String hql="FROM ReplyEntity R WHERE R.repliedBy = '"+userName+"' order by category";
			Query query = hibSession.createQuery(hql);
			List results = query.list();
			
			for (Iterator iterator = 
					results.iterator(); iterator.hasNext();){
				ReplyEntity replyEntity = (ReplyEntity) iterator.next();
				
				if(replyEntity.getCategory().equals("Event"))
				{
					eventCount++;
				}
				else if(replyEntity.getCategory().equals("Food"))
				{
					foodCount++;
				}
				else if(replyEntity.getCategory().equals("Landmark"))
				{
					landmarkCount++;
				}
				else if(replyEntity.getCategory().equals("Travel"))
				{
					travelCount++;
				}
			}			
			bMap.put("Event", eventCount);
			bMap.put("Food", foodCount);
			bMap.put("Landmark", landmarkCount);
			bMap.put("Travel", travelCount);
		}
		finally
		{
			hibSession.close();
		}
		
		return bMap;
		
	}

}
