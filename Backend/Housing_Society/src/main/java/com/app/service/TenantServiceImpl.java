package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojo.Complaint;
import com.app.pojo.Owner;
import com.app.pojo.Tenant;
import com.app.pojo.User;
import com.app.repository.SecretaryRepository;
import com.app.repository.TenantRepository;
import com.app.repositoryTemp.TenantRepositoryTemp;

@Service
@Transactional
public class TenantServiceImpl implements ITenantService {

	@Autowired
	private TenantRepository repo;

	@Autowired
	private TenantRepositoryTemp repoTemp;

	// Tenant Login
	@Override
	public User getLogin(String email, String password) {

		User user = repo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));

		return user;
	}

	// Add Complaint
	@Override
	public String putComplaint(String complaint, long id) {
		Tenant tenant = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User Found"));

		// add expiry Date Later
		Complaint comp = new Complaint(complaint);
		tenant.addComplaint(comp);
		comp.setSecretary(tenant.getOwner().getSecretary());
		if(tenant.getOwner().getSecretary().getMaintainanceTeam().size()>0) {
		comp.setMaintainanceTeam(tenant.getOwner().getSecretary().getMaintainanceTeam().get(0));
		}

		return complaint;
	}
	
	
	//show complaints
	@Override
	public List<Complaint> allComplaints(long id) {
		Tenant tenant = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User Found"));

		List<Complaint> complaints = tenant.getComplaints();

		return complaints;
	}

}
