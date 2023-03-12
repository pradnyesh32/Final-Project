package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "tenants_temp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenantTemp extends User {

	private int flatNo;

	@NotBlank(message = "Housing Society Name is required")
	private String societyName;
	

	public TenantTemp(
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstName,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastName,
			@Email @NotBlank(message = "email is required") String email,
			@NotBlank(message = "password is required") String password, long mobileNumber, UserRole role, int flatNo,
			String societyName) {
		super(firstName, lastName, email, password, mobileNumber, role);
		this.societyName = societyName;
		this.flatNo = flatNo;
	}

	public TenantTemp(String email, String password) {
		super(email, password);
	}

}
