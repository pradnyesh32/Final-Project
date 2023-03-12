package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Secretary;
import com.app.pojo.User;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);
	
	

}
