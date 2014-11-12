package com.asu.tolc.utilities;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtility {

	public static void viaGmail(String messageBody,
			String subject ,List<String> emailList) throws Exception
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
			message.setSubject(subject);
			message.setText(messageBody);
 
			
			Transport.send(message);
 
	}

}
