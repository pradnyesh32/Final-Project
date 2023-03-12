package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojo.Complaint;
import com.app.pojo.ComplaintStatus;
import com.app.pojo.MaintainanceTeam;
import com.app.pojo.User;
import com.app.repository.ComplaintRepository;
import com.app.repository.MaintainanceTeamRepository;
import com.app.repository.OwnerRepository;


@Service
@Transactional
public class MaintainanceTeamServiceImpl implements IMaintainanceTeamService {

	@Autowired
	private MaintainanceTeamRepository repo;
	
	@Autowired
	private ComplaintRepository complaintRepo ;
	
	@Override
	public User getLogin(String email, String password) {
		
		User user = repo.findByEmailAndPassword(email, password).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		
		return user;
	}
	
	
	
	@Override
	public List<Complaint> allComplaints(long id) {
		
		MaintainanceTeam mteam = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
	
		List<Complaint> list = mteam.getComplaint();
		
		return list;
	}

	
	
	@Override
	public String deleteComplaints(long id) {
		Complaint comp = complaintRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		comp.setStatus(ComplaintStatus.RESOLVED);
		return "Resolved";
	}
	
	

}
