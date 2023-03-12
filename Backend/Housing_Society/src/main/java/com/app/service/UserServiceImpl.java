package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.IdRoleDto;
import com.app.dto.LoginDto;
import com.app.dto.RegisterDto;
import com.app.email.EmailSenderService;
import com.app.pojo.Accountant;
import com.app.pojo.AccountantTemp;
import com.app.pojo.Maintainance;
import com.app.pojo.MaintainanceTeam;
import com.app.pojo.MaintainanceTeamTemp;
import com.app.pojo.Owner;
import com.app.pojo.OwnerTemp;
import com.app.pojo.Secretary;
import com.app.pojo.Tenant;
import com.app.pojo.TenantTemp;
import com.app.pojo.User;
import com.app.pojo.UserRole;
import com.app.repository.AccountantRepository;
import com.app.repository.MaintainanceRepository;
import com.app.repository.SecretaryRepository;
import com.app.repository.UserRepository;
import com.app.repositoryTemp.AccountantRepositoryTemp;
import com.app.repositoryTemp.MaintainanceTeamRepositoryTemp;
import com.app.repositoryTemp.OwnerRepositoryTemp;
import com.app.repositoryTemp.TenantRepositoryTemp;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository repo;
	
	
	@Autowired
	private SecretaryRepository secretaryRepo;
	
	
	@Autowired
	private  OwnerRepositoryTemp ownerRepoTemp;
	
	
	
	
	@Autowired
	private TenantRepositoryTemp tenantRepoTemp;
	
	@Autowired
	private  AccountantRepositoryTemp accountantRepoTemp;
	
	@Autowired
	private MaintainanceTeamRepositoryTemp maintainanceTeamRepoTemp;
	
	@Autowired
	private IEmailService emailService;
	
	@Autowired
	private  AccountantRepository accountantRepo;
	
	@Autowired
	private MaintainanceRepository maintainanceRepo;
	

	@Override
	public User registerUser(RegisterDto request,String otp) {
		
		emailService.getVerify(request,otp);
		
		
		User user=null;
		if(request.getRole().equals(UserRole.SECRETARY)) {
		user = new Secretary(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getSocietyName());
		 }
		else if(request.getRole().equals(UserRole.OWNER)) {
			
			user = new OwnerTemp(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getFlatNo(),request.getSocietyName());
		}
		else if(request.getRole().equals(UserRole.TENANT)) {
			
			user = new TenantTemp(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getFlatNo(),request.getSocietyName());
		}
		else if(request.getRole().equals(UserRole.ACCOUNTANT)) {
			
			user = new AccountantTemp(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getSocietyName());
		}
		else if(request.getRole().equals(UserRole.MAINTAINANCE_TEAM)) {
			
			user = new MaintainanceTeamTemp(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getDepartment(),request.getSocietyName());
		}
		 
		return repo.save(user);
	}

	
	@Override
	public User loginUser(LoginDto request) {
		String email = request.getEmail();
		String password = request.getPassword();
		
		 
		return null;
		
		
	
	}


	@Override
	public User addTemp(User ird, long id) {
		
		
		User user=null;
		Secretary sec = secretaryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("no secretary"));
		
		if(ird.getRole().equals(UserRole.OWNER)) {
			
			
			
			OwnerTemp request =ownerRepoTemp.findById(ird.getId()).orElseThrow(()->new ResourceNotFoundException("no owner"));
			System.out.println(request);
			
			Owner owner = new Owner(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getFlatNo());
			sec.addOwner(owner);
			
			System.out.println(sec);
			
			
//			@NotBlank(message = "Amount is required") double paid,
//			@NotBlank(message = "Amount is required") double totalMaintainance,
//			@NotBlank(message = "Date is required") LocalDate dueDate,
//			@NotBlank(message = "Date is required") LocalDate assignDate, @Length(max = 50) String description,
//			Secretary secretary,
//			Owner owner,
//			Accountant accountant
			
			
			if(owner.getSecretary().getAccountant().get(0)!=null) {
				
			
			
			//Add Maintainance
			Maintainance maintainance = new Maintainance(0.0,LocalDate.now().plusDays(30),LocalDate.now(),"Maintainance");
			
			sec.getAccountant().get(0).addMaintainance(maintainance);
			
			
			owner.addMaintainance(maintainance);
			}
			
			return repo.save(owner);
			
			
			
		}
		else if(ird.getRole().equals(UserRole.TENANT)) {
			
			TenantTemp request =tenantRepoTemp.findById(ird.getId()).orElseThrow(()->new ResourceNotFoundException("no tenant"));
			
			
			Tenant tenant = new Tenant(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getFlatNo());
			
			
		}
		else if(ird.getRole().equals(UserRole.ACCOUNTANT)) {
			
			AccountantTemp request =accountantRepoTemp.findById(ird.getId()).orElseThrow(()->new ResourceNotFoundException("no accountant"));
			
			
			
			Accountant accountant = new Accountant(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole());
			
			sec.addAccountant(accountant);
			
			return repo.save(accountant);
			
		}
		else if(ird.getRole().equals(UserRole.MAINTAINANCE_TEAM)) {
			
			MaintainanceTeamTemp request =maintainanceTeamRepoTemp.findById(ird.getId()).orElseThrow(()->new ResourceNotFoundException("no maintainance team"));
			
			
			MaintainanceTeam maintainanceTeam = new MaintainanceTeam(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),request.getMobileNumber(),request.getRole(),request.getDepartment());
			
			sec.addMaintainanceTeam(maintainanceTeam);
			
			return repo.save(maintainanceTeam);
		}
		 
		return repo.save(user);
	}


	@Override
	public RegisterDto tempUser(RegisterDto request) {
	try {	
		String vemail = emailService.getVerification(request);
		return request;
	}catch(Exception e) {
		e.printStackTrace();
		return request;
	}
		
	}

	


}
