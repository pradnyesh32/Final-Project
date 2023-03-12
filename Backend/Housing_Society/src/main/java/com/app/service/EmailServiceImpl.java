package com.app.service;

import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.RegisterDto;
import com.app.email.EmailSenderService;
import com.app.pojo.EmailVerification;
import com.app.repositoryTemp.EmailRepository;


@Service
@Transactional
public class EmailServiceImpl implements IEmailService {
	
	@Autowired
	private EmailSenderService emailSender;
	
	@Autowired
	private EmailRepository repo;

	@Override
	public String getVerification(RegisterDto request) {
		
		Random r = new Random();
		int random=0;
		while(random<1001) {
		 random= r.nextInt(9998);
		}
		String password = Integer.toString(random);
		emailSender.sendEmail(request.getEmail(), "null", "Your OTP for Hosing Society Portal is "+password);
		
		EmailVerification ev = new EmailVerification(request.getEmail(),password);
		repo.save(ev);
		
		return request.getEmail();
	}

	@Override
	public EmailVerification getVerify(RegisterDto request, String otp) {
		EmailVerification ev =  repo.findByEmailAndPassword(request.getEmail(),otp).orElseThrow(()->(new ResourceNotFoundException("Wrong Otp ")));
		return ev;
		
	}


}
