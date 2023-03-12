package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Complaint;
import com.app.service.IMaintainanceTeamService;

@RestController
@RequestMapping("/maintainanceteam")
@CrossOrigin(origins = "http://localhost:3000")
public class MaintainanceTeamController {
	
	@Autowired
	private IMaintainanceTeamService mteamService;
	
	//Use MainTeam id
	@GetMapping("/complaint/show/{id}")
	public ResponseEntity<List<Complaint>> getComplaint(@PathVariable long id) {
		List<Complaint> comps = mteamService.allComplaints(id);
		return ResponseEntity.ok(comps);
	}
	
	//Use Complaint id
	@GetMapping("/complaint/resolve/{id}")
	public ResponseEntity<?> resolveComplaint(@PathVariable long id) {
		String comps = mteamService.deleteComplaints(id);
		return ResponseEntity.ok(comps);
	}
	
	
	
}
