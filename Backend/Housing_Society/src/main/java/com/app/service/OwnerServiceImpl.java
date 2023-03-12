package com.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.DescriptionAmountDto;
import com.app.dto.IdRoleDto;
import com.app.pojo.Complaint;
import com.app.pojo.Maintainance;
import com.app.pojo.Owner;

import com.app.pojo.Secretary;
import com.app.pojo.Tenant;
import com.app.pojo.TenantTemp;
import com.app.pojo.User;
import com.app.repository.OwnerRepository;
import com.app.repository.TenantRepository;
import com.app.repositoryTemp.TenantRepositoryTemp;

@Service
@Transactional
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	private OwnerRepository repo;

	@Autowired
	private TenantRepositoryTemp tenantRepoTemp;
	
	@Autowired
	private TenantRepository tenantRepo;

	

	// Login
	@Override
	public User getLogin(String email, String password) {

		User user = repo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));

		return user;
	}

	// Get Pending Tenant Request
	@Override
	public List<User> pendingRequest(long id) {
		List<User> list = new ArrayList<User>();
		List<TenantTemp> tenants = tenantRepoTemp.findAll();
		Owner owner = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No data found for user"));
		Secretary secretary = owner.getSecretary();
		String society = secretary.getSocietyName();

		for (TenantTemp tenant : tenants) {
			if (society.equals(tenant.getSocietyName()) && tenant.getFlatNo() == owner.getFlatNo()) {
				list.add(tenant);
			}
		}

		return list;
	}

	// Add Complaint
	@Override
	public String putComplaint(String complaint, long id) {
		Owner owner = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User Found"));

		// add expiry Date Later
		Complaint comp = new Complaint(complaint);
		owner.addComplaint(comp);
		comp.setSecretary(owner.getSecretary());
		if(owner.getSecretary().getMaintainanceTeam().size()>0) {
		comp.setMaintainanceTeam(owner.getSecretary().getMaintainanceTeam().get(0));
		}

		return complaint;
	}
	
	
	
	@Override
	public List<Complaint> allComplaints(long id) {
		Owner owner=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No User Found"));
		
		List<Complaint> complaints=owner.getComplaint();
		
		return complaints;
	}
	
	
	
	@Override
	public User addTemp(User ird, long id) {
		
		Owner owner = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("no Owner"));
		
		TenantTemp request =tenantRepoTemp.findById(ird.getId()).orElseThrow(()->new ResourceNotFoundException("no owner"));
		
		Tenant tenant = new Tenant(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getFlatNo());
		owner.addTenant(tenant);
		
		
		return tenantRepo.save(tenant);
	}
	
	
	
	@Override
	public String payment(DescriptionAmountDto dad, long id) {
		
		Owner owner = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("no Owner"));
		
		Maintainance m = owner.getMaintainance();
		
		m.setPaid(m.getPaid()+dad.getAmount());
		m.setTotalMaintainance(m.getTotalMaintainance()-dad.getAmount());
		
		return "Paid";
	}
	
	

}
