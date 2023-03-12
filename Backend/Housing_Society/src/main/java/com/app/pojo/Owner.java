package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends User {
	
	
	private int flatNo;
	
	@ManyToOne
	private Secretary secretary;
	
	@OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
	@JsonIgnore
	private Tenant tenant;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Complaint> complaint;

	@OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
	@JsonIgnore
	private Maintainance maintainance;

	public Owner(
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstName,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastName,
			@Email @NotBlank(message = "email is required") String email,
			@NotBlank(message = "password is required") String password,
			long mobileNumber, UserRole role,int flatNo) {
		super(firstName, lastName, email, password, mobileNumber, role);
		this.flatNo=flatNo;
		
	}

	public Owner(String email, String password) {
		super(email,password);
	}

	public void addComplaint(Complaint comp) {
		complaint.add(comp);
		comp.setOwner(this);
	}
	
	public void addMaintainance(Maintainance maintain) {
		this.setMaintainance(maintain);
		maintain.setOwner(this);
	}

	public void addTenant(Tenant tenant) {
		tenant.setOwner(this);
		this.setTenant(tenant);
		
	}
	
	
	
//	public void addSecretary(Secretary sec) {
//		this.secretary=sec;
//		sec.setOwner(this);
//	}
	
	
	
	
	
	
}
