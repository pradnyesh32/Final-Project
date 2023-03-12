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
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tenant extends User{


 private int flatNo;
 
 @OneToOne
 private Owner owner;

 @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
 @JsonIgnore
 private List<Complaint> complaints;

public Tenant(
		@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstName,
		@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastName,
		@Email @NotBlank(message = "email is required") String email,
		@NotBlank(message = "password is required") String password, long mobileNumber, UserRole role,int flatNo) {
	super(firstName, lastName, email, password, mobileNumber, role);
	this.flatNo=flatNo;
}

public Tenant(String email, String password) {
	super(email,password);
}


//Complaint Helper Method
public void addComplaint(Complaint comp) {
	complaints.add(comp);
	comp.setTenant(this);
	
}


}
