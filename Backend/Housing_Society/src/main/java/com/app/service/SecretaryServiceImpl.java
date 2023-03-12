package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojo.AccountantTemp;
import com.app.pojo.MaintainanceTeamTemp;
import com.app.pojo.Notification;
import com.app.pojo.OwnerTemp;
import com.app.pojo.Secretary;
import com.app.pojo.TenantTemp;
import com.app.pojo.User;
import com.app.pojo.UserRole;
import com.app.repository.NotificationRepository;
import com.app.repository.SecretaryRepository;
import com.app.repository.UserRepository;
import com.app.repositoryTemp.AccountantRepositoryTemp;
import com.app.repositoryTemp.MaintainanceTeamRepositoryTemp;
import com.app.repositoryTemp.OwnerRepositoryTemp;
import com.app.repositoryTemp.TenantRepositoryTemp;

@Service
@Transactional
public class SecretaryServiceImpl implements ISecretaryService{
	
	@Autowired
	private  OwnerRepositoryTemp ownerRepoTemp;
	
	
	
	@Autowired
	private TenantRepositoryTemp tenantRepoTemp;
	
	@Autowired
	private  AccountantRepositoryTemp accountantRepoTemp;
	
	@Autowired
	private MaintainanceTeamRepositoryTemp maintainanceTeamRepoTemp;
	
	
	@Autowired
	private  SecretaryRepository repo;
	
	@Autowired
	private  NotificationRepository notificationRepo;
	
	

	@Override
	public User getLogin(String email, String password) {
		
		User user = repo.findByEmailAndPassword(email, password).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		
		return user;
	}

	@Override
	public List<String> getSociety() {
		
		List<Secretary> secretaries = repo.findAll();
		List<String> list=new ArrayList<String>(secretaries.size());
		System.out.println(secretaries.size());
		for(int i = 0 ; i<secretaries.size();i++) {
			list.add(secretaries.get(i).getSocietyName());
		}
		
		
		return list;
	}

	@Override
	public List<User> pendingRequest(long id) {
		List<User> list = new ArrayList<User>();
		List<AccountantTemp> accountants=accountantRepoTemp.findAll();
		List<OwnerTemp> owners=ownerRepoTemp.findAll();
		List<MaintainanceTeamTemp> mteam=maintainanceTeamRepoTemp.findAll();
		
		Secretary secretary=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No data found for user"));
		String society = secretary.getSocietyName();
		
		for(AccountantTemp act:accountants) {
			if(society.equals(act.getSocietyName())) {
			list.add(act);
			}
		}
		for(OwnerTemp owner:owners) {
			if(society.equals(owner.getSocietyName())) {
				list.add(owner);
				}
		}
		
		for(MaintainanceTeamTemp maintain:mteam) {
			if(society.equals(maintain.getSocietyName())) {
				list.add(maintain);
				}
		}
		
		return list;
	}

	
	@Override
	public String putNotification(String notice,long id) {
		
		Secretary sec=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No User Found"));
		
		//add expiry Date Later
		Notification note=new Notification(LocalDate.now(), LocalDate.now().plusDays(30), notice);
		sec.addNotification(note);
		
		
		return notice;
	}

	
	
	@Override
	public List<Notification> allNoifications(long id) {
		Secretary sec=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No User Found"));
		
		List<Notification> notifications=sec.getNotifications();
		
		
		
		return notifications;
	}

	@Override
	public String deleteTemp(User request) {
		
		try {
		
		
			if(request.getRole().equals(UserRole.OWNER)) {
				
				ownerRepoTemp.deleteById(request.getId());
			}
			else if(request.getRole().equals(UserRole.TENANT)) {
				
				tenantRepoTemp.deleteById(request.getId());
			}
			else if(request.getRole().equals(UserRole.ACCOUNTANT)) {
				
				accountantRepoTemp.deleteById(request.getId());
			}
			else if(request.getRole().equals(UserRole.MAINTAINANCE_TEAM)) {
				
				maintainanceTeamRepoTemp.deleteById(request.getId());
			}
			
			return "Deleted Sucessfully";
		}catch (RuntimeException e) {
			
			throw new ResourceNotFoundException("No Data To Delete");
		}
		
		
	}

	@Override
	public String deleteNoifications(long id) {
		Notification note = notificationRepo.findById(id).orElseThrow(()->(new ResourceNotFoundException("no notification")));
		
		notificationRepo.delete(note);
		return "Deleted Sucessfully";
	}

	

}
