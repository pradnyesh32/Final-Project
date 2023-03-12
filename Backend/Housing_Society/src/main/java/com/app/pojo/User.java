package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Length(min = 3, max = 20, message = "Invalid len of Name")
	@Column(length = 20)
	@NotBlank(message = "firstName is required")
	private String firstName;
	
	
	@Length(min = 3, max = 20, message = "Invalid len of Name")
	@Column(length = 20)
	@NotBlank(message = "lastName is required")
	private String lastName;

	
	@Email
	@NotBlank(message = "email is required")
	private String email;
	
	
	@NotBlank(message = "password is required")
	//@Pattern(regexp = "((?=.\\d)(?=.[a-z])(?=.[#@$]).{5,20})", message = "Blank or Invalid password")
	@Column(length = 20)
	@JsonIgnore
	private String password;
	
	
	private long mobileNumber;
	

	@Enumerated(EnumType.STRING)
	private UserRole role;


	public User(
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstName,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastName,
			@Email @NotBlank(message = "email is required") String email,
			@NotBlank(message = "password is required")  String password,
			long mobileNumber, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
	}


	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}

	
	
	
	

	
	
	
}
