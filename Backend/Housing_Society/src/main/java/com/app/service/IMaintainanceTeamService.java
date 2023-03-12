package com.app.service;

import java.util.List;

import com.app.pojo.Complaint;
import com.app.pojo.User;

public interface IMaintainanceTeamService {

	User getLogin(String email, String password);

	List<Complaint> allComplaints(long id);

	String deleteComplaints(long id);

}
