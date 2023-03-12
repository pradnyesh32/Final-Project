package com.app.service;

import java.util.List;

import com.app.pojo.Maintainance;
import com.app.pojo.User;

public interface IAccountantService {

	User getLogin(String email, String password);

	String newMaintainance(String description, double amount, long id);

	List<Maintainance> getAllMaintainance(long id);
	

}
