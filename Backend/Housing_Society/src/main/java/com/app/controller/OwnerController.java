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
import com.app.dto.IdRoleDto;
import com.app.dto.Notice;
import com.app.pojo.Complaint;
import com.app.pojo.User;
import com.app.service.IOwnerService;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "http://localhost:3000")
public class OwnerController {

	@Autowired
	private IOwnerService ownerService;

	@GetMapping("/pendingrequest/{id}")
	public List<User> getDetails(@PathVariable long id) {

		return ownerService.pendingRequest(id);
	}

	@PostMapping("/complaint/add/{id}")
	public ResponseEntity<String> addComplaint(@RequestBody Notice notice, @PathVariable long id) {
		String notify = ownerService.putComplaint(notice.getDiscription(), id);
		return ResponseEntity.ok(notify);
	}

	@GetMapping("/complaint/show/{id}")
	public ResponseEntity<List<Complaint>> getComplaint(@PathVariable long id) {
		List<Complaint> comps = ownerService.allComplaints(id);
		return ResponseEntity.ok(comps);
	}

	@PostMapping("/addrequest/{id}")
	public ResponseEntity<?> addRequest(@RequestBody User ird, @PathVariable long id) {

		return ResponseEntity.ok(ownerService.addTemp(ird, id));
	}

	@PostMapping("/paymaintainance/{id}")
	public ResponseEntity<?> payMaintanance(@RequestBody DescriptionAmountDto dad, @PathVariable long id) {

		return ResponseEntity.ok(ownerService.payment(dad, id));
	}

}
