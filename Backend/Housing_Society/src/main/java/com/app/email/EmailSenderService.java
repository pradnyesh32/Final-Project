package com.app.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(String emailTo,String subject,String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("pradnyeshkadam7032@gmail.com");
		message.setTo(emailTo);
		message.setText(body);
		message.setSubject("Email Verifiction Mail From Housing Society Portal Please Confirm Your Email");
		
		mailsender.send(message);

		System.out.println("sucessful");
	}
	

}
