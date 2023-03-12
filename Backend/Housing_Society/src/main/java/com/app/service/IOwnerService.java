package com.app.service;

import java.util.List;

import com.app.dto.DescriptionAmountDto;
import com.app.dto.IdRoleDto;
import com.app.dto.Notice;
import com.app.pojo.Complaint;
import com.app.pojo.User;

public interface IOwnerService {

	User getLogin(String email, String password);

	List<User> pendingRequest(long id);

	String putComplaint(String complaint, long id);

	List<Complaint> allComplaints(long id);

	User addTemp(User ird, long id);

	String payment(DescriptionAmountDto dad, long id);

}
