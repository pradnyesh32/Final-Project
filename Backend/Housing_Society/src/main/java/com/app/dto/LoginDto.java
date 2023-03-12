package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.app.pojo.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {
	
	@NotBlank(message = "email is required")
	private String email;
	
	@NotBlank(message = "email is required")
	private String password;
	
	private UserRole role;

}
