package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Maintainance;

public interface MaintainanceRepository extends JpaRepository<Maintainance, Long> {

}
