package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
