package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Tenant;
import com.app.pojo.User;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);

}
