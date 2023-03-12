package com.app.service;

import java.util.List;

import com.app.pojo.Complaint;
import com.app.pojo.User;

public interface ITenantService {

	User getLogin(String email, String password);

	String putComplaint(String complaint, long id);

	List<Complaint> allComplaints(long id);

}
