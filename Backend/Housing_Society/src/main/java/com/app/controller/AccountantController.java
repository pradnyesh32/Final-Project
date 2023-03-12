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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DescriptionAmountDto;
import com.app.pojo.Maintainance;
import com.app.service.IAccountantService;



@RestController
@RequestMapping("/accountant")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountantController {
	
	@Autowired
	private IAccountantService accountantService;
	
	
	
	@PostMapping("/addmaintainance/{id}")
	public ResponseEntity<?> addMaintainance(@RequestBody DescriptionAmountDto dad,@PathVariable long id){
		
		System.out.println(dad.getDescription()+"  "+dad.getAmount());
		
		String status = accountantService.newMaintainance(dad.getDescription(),dad.getAmount(),id);
		
		return ResponseEntity.ok(status);
	}
	
	@GetMapping("/getdata/{id}")
	public ResponseEntity<?> getData(@PathVariable long id){
		
		List<Maintainance> list = accountantService.getAllMaintainance(id);
		
		return ResponseEntity.ok(list);
	}
	
	
}
