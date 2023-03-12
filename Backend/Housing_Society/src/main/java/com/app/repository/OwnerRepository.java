package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Owner;
import com.app.pojo.User;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);

}
