package com.app.dto;

import com.app.pojo.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdRoleDto {
	
	private long id;
	private UserRole role;

}
