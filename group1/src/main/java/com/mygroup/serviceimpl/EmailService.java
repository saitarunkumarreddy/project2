package com.mygroup.serviceimpl;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mygroup.model.UserDetails1;



@Service
public class EmailService {
	public static final String REPLY_TO_ADDRESS="donotreply@buytoys.com";
	public static final String FROM_ADDRESS="registration@buytoys.com";
	@Autowired
	public JavaMailSender javaMailSender;
public void send(UserDetails1 userdetails, String subject,String body) throws MessagingException
{
	
/*	 MimeMessage mail=javaMailSender.createMimeMessage();
	 MimeMessageHelper helper=new MimeMessageHelper(mail,true);
	 mail.setTo(userdetails.getEmailid());
	 mail.setReplyTo(new InternetAddress(REPLY_TO_ADDRESS));
	 mail.setFrom(new InternetAddress(FROM_ADDRESS));
	 helper.setSubject(subject);
	helper.setText(body);
	javaMailSender.send(mail);
		mail.setrep*/
	 
}	

}



/*MimeMessage mail=javaMailSender.createMimeMessage();
MimeMessageHelper helper=new MimeMessageHelper(mail,true);
helper.setTo(userdetails.getEmailid());
helper.setReplyTo(REPLY_TO_ADDRESS);
helper.setFrom(FROM_ADDRESS);
helper.setSubject(subject);
helper.setText(body);
javaMailSender.send(mail);*/