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

import com.app.dto.Notice;
import com.app.pojo.Complaint;
import com.app.service.IOwnerService;
import com.app.service.ITenantService;

@RestController
@RequestMapping("/tenant")
@CrossOrigin(origins = "http://localhost:3000")
public class TenantController {
	
	
	@Autowired
	private ITenantService tenantService;
	
	
	
	//Add Complaint
	@PostMapping("/complaint/add/{id}")
	public ResponseEntity<String> addComplaint(@RequestBody Notice notice,@PathVariable long id){
			String notify=tenantService.putComplaint(notice.getDiscription(),id);
			return ResponseEntity.ok(notify);
	}
	
	
	@GetMapping("/complaint/show/{id}")
	public ResponseEntity<List<Complaint>> getComplaint(@PathVariable long id) {
		List<Complaint> comps = tenantService.allComplaints(id);
		return ResponseEntity.ok(comps);
	}

}
