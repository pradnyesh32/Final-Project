package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojo.Accountant;
import com.app.pojo.Maintainance;
import com.app.pojo.User;
import com.app.repository.AccountantRepository;
import com.app.repository.MaintainanceRepository;
import com.app.repository.TenantRepository;
import com.app.repositoryTemp.AccountantRepositoryTemp;

@Service
@Transactional
public class AccountantServiceImpl implements IAccountantService {
	
	@Autowired
	private AccountantRepository repo;
	
	@Autowired
	private AccountantRepositoryTemp repotemp;
	
	@Autowired
	private MaintainanceRepository maintainanceRepo;
	
	
	
	//Login
	@Override
	public User getLogin(String email, String password) {
		
		User user = repo.findByEmailAndPassword(email, password).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		
		return user;
	}


	//Add Maintainance
//	public String maintainance(String description, double amount, long id) {
//		 
//		Maintainance m = new Maintainance(amount,LocalDate.now(),LocalDate.now().plusDays(30),description);
//		
//		Accountant accountant = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
//		
//		accountant.addMaintainance(m);
//		Maintainance maintain =  maintainanceRepo.save(m);
//		if(maintain!=null) {
//			return "maintainance added";
//		}
//		
//		return "Failed to add" ;
//	}
	
	@Override
	public String newMaintainance(String description, double amount, long id) {
		 
		Accountant accountant = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		
		List<Maintainance> maintainance = accountant.getMaintainance();
		
		maintainance.forEach((m)->m.setTotalMaintainance(m.getTotalMaintainance()+amount));
		
		return "Added Maintainance";
	}


	@Override
	public List<Maintainance> getAllMaintainance(long id) {
		Accountant accountant = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!!"));
		
		System.out.println(accountant);
		List<Maintainance> list =accountant.getMaintainance();
		
		return list;
	}
	
	
	

}
