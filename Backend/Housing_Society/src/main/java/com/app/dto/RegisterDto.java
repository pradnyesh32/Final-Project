package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.app.pojo.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterDto {
	
	private Long id;
	
	 @Length(min = 3, max = 20, message = "Invalid len of Name")
	 @NotBlank(message = "firstName is required") 
	 private String firstName;
	 
	@Length(min = 3, max = 20, message = "Invalid len of Name")
	@NotBlank(message = "lastName is required")
	private String lastName;
	
	 @Email 
	 @NotBlank(message = "email is required") 
	 private String email;
	 
	 @NotBlank(message = "password is required")  
	 private String password;
	 
	 private long mobileNumber;
	 
	 @NotBlank(message = "Housing Society Name is required")  
	 private String societyName;
	
	 
	 private UserRole role;
	
	 private int flatNo;
	
	private String department;

}
