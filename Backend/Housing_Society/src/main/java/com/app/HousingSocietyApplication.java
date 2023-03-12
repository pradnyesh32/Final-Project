package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.email.EmailSenderService;

@SpringBootApplication
public class HousingSocietyApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HousingSocietyApplication.class, args);
	}

}
