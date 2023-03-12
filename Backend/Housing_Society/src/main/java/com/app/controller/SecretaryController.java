package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.IdRoleDto;
import com.app.dto.Notice;
import com.app.pojo.Notification;
import com.app.pojo.User;
import com.app.service.ISecretaryService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/secretary")
@CrossOrigin(origins = "http://localhost:3000")
public class SecretaryController {
	
	@Autowired
	private ISecretaryService secretaryService;
	
	@Autowired
	private IUserService userService;
	
	//Secretary ID Parameter
	@GetMapping("/pendingrequest/{id}")
	public List<User> getDetails(@PathVariable long id){
		
		return secretaryService.pendingRequest(id);
	}
	
	//Secretary ID Parameter
	@PostMapping("/notification/add/{id}")
	public ResponseEntity<String> addNoification(@RequestBody Notice notice,@PathVariable long id){
			String notify=secretaryService.putNotification(notice.getDiscription(),id);
			return ResponseEntity.ok(notify);
	}

	
	
	//Same Methods For Tenant And Owner
	@GetMapping("/notifications/show/{id}")
	public ResponseEntity<List<Notification>> getNotifications(@PathVariable long id){
		
		
		return ResponseEntity.ok(secretaryService.allNoifications(id));
	}
	
	//Use notification id
	@GetMapping("/notifications/delete/{id}")
	public ResponseEntity<?> deleteNotifications(@PathVariable long id){
		
		
		return ResponseEntity.ok(secretaryService.deleteNoifications(id));
	}
	
	
	
	@PostMapping("/deleterequest")
	public String deleteRequest(@RequestBody User user) {
		
		return secretaryService.deleteTemp(user);
		}
	
	
	//Secretary ID Parameter
	@PostMapping("/addrequest/{id}")
	public User addRequest(@RequestBody User ird,@PathVariable long id) {
		
		
		return userService.addTemp(ird,id);
		}
	
	
		
	
	
	
		
	
	

}
