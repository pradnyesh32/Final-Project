package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "accountant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accountant extends User {
	
	@ManyToOne
	private Secretary secretary;
	
	@OneToMany(mappedBy = "accountant", cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Maintainance> maintainance;

	

	public Accountant(String email, String password) {
		super(email,password);
	}



	public Accountant(
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstName,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastName,
			@Email @NotBlank(message = "email is required") String email,
			@NotBlank(message = "password is required") String password, long mobileNumber, UserRole role) {
		super(firstName, lastName, email, password, mobileNumber, role);
		
	}



	public void addMaintainance(Maintainance m) {
		m.setAccountant(this);
		maintainance.add(m);
		
	}
	
	
	
	

}
