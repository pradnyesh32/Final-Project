package com.app.repositoryTemp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.EmailVerification;


public interface EmailRepository extends JpaRepository<EmailVerification, Long> {

	Optional<EmailVerification> findByEmailAndPassword(String email, String otp);
	
	

}
