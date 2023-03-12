package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.RegisterDto;

import com.app.pojo.User;
import com.app.pojo.UserRole;
import com.app.service.IAccountantService;
import com.app.service.IMaintainanceTeamService;
import com.app.service.IOwnerService;
import com.app.service.ISecretaryService;
import com.app.service.ITenantService;
import com.app.service.IUserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOwnerService ownerService;
	
	@Autowired
	private ISecretaryService secretaryService;
	
	@Autowired
	private ITenantService tenantService;
	
	@Autowired
	private IAccountantService accountantService;
	
	@Autowired
	private IMaintainanceTeamService maintainanceTeamService;
	
	@PostMapping("/verify/{otp}")
	public ResponseEntity<?> userVerification(@RequestBody RegisterDto request,@PathVariable String otp){
		return ResponseEntity.ok(userService.registerUser(request,otp));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody RegisterDto request){
		return ResponseEntity.ok(userService.tempUser(request));
}
	@PostMapping("/signin")
	public ResponseEntity<?> userLogin(@RequestBody LoginDto request){
		String email = request.getEmail();
		String password = request.getPassword();
		User user=null;
		if(request.getRole().equals(UserRole.SECRETARY)) {
		user = secretaryService.getLogin(email,password);
		 }
		else if(request.getRole().equals(UserRole.OWNER)) {
			
			user = ownerService.getLogin(email,password);
		}
		else if(request.getRole().equals(UserRole.TENANT)) {
			
			user = tenantService.getLogin(email,password);
		}
		else if(request.getRole().equals(UserRole.ACCOUNTANT)) {
			
			user = accountantService.getLogin(email,password);
		}
		else if(request.getRole().equals(UserRole.MAINTAINANCE_TEAM)) {
			
			user = maintainanceTeamService.getLogin(email,password);
		}
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/societynames")
	public List<String> getSocietyNames(){
		secretaryService.getSociety();
		return secretaryService.getSociety();
	}

}
                                