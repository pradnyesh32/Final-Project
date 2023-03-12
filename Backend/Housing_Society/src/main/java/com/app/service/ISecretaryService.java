package com.app.service;

import java.util.List;

import com.app.pojo.Notification;
import com.app.pojo.User;

public interface ISecretaryService {

	User getLogin(String email, String password);

	List<String> getSociety();

	List<User> pendingRequest(long id);

	String putNotification(String notice, long id);

	List<Notification> allNoifications(long id);

	String deleteTemp(User user);

	String deleteNoifications(long id);

	

}
