package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Maintainance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private double paid;
	
	
	private double totalMaintainance;
	
	
	private LocalDate dueDate;
	
	
	private LocalDate assignDate;
	
	@Length(max = 50)
	private String description;
	
	@JsonIgnore
	@OneToOne
	private Owner owner;
	
	@JsonIgnore
	@ManyToOne
	private Accountant accountant;

	public Maintainance(
			@NotBlank(message = "Amount is required") double totalMaintainance,
			@NotBlank(message = "Date is required") LocalDate dueDate,
			@NotBlank(message = "Date is required") LocalDate assignDate, @Length(max = 50) String description) {
		super();
		this.totalMaintainance = totalMaintainance;
		this.dueDate = dueDate;
		this.assignDate = LocalDate.now();
		this.description = description;
	}

}
