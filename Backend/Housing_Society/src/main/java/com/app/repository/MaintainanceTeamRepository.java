package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.MaintainanceTeam;
import com.app.pojo.User;

public interface MaintainanceTeamRepository extends JpaRepository<MaintainanceTeam, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);

}
