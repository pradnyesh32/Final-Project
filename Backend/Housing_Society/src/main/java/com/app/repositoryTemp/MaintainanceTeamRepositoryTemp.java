package com.app.repositoryTemp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojo.MaintainanceTeamTemp;
import com.app.pojo.User;

public interface MaintainanceTeamRepositoryTemp extends JpaRepository<MaintainanceTeamTemp, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);

	

}
