package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Secretary extends User {
	
	

	public Secretary(
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstName,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastName,
			@Email @NotBlank(message = "email is required") String email,
			@NotBlank(message = "password is required") String password, long mobileNumber, UserRole role,String societyName ) {
		super(firstName, lastName, email, password, mobileNumber, role);
		this.societyName=societyName;
		
	}

	public Secretary(String email, String password) {
		super(email,password);
	}

	@OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Owner> owner;
	
	@OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Accountant> accountant;
	
	@OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<MaintainanceTeam> maintainanceTeam;
	
	@OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Notification> notifications;
	
	
	@OneToMany(mappedBy = "secretary", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Complaint> complaints; 
	
	@NotBlank(message = "Housing Society Name is required")  
	private String societyName;
	
	
	public void addNotification(Notification note) {
		notifications.add(note);
		note.setSecretary(this);
	}
	
	
	public void addOwner(Owner own) {
		owner.add(own);
		own.setSecretary(this);
	}
	
	public void addAccountant(Accountant acc) {
		accountant.add(acc);
		acc.setSecretary(this);
	}
	
	public void addMaintainanceTeam(MaintainanceTeam mteam) {
		maintainanceTeam.add(mteam);
		mteam.setSecretary(this);
		
	}
	
	public void addComplaint(Complaint comp) {
		complaints.add(comp);
		comp.setSecretary(this);
	}
	                                                                                                                 
	
	

}
