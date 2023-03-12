package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long notificationId;
	
	private LocalDate assignDate;
	
	private LocalDate endDate;
	
	private String description;
	
	@ManyToOne
	@JsonIgnore
	private Secretary secretary;

	public Notification(LocalDate assignDate, LocalDate endDate, String description) {
		super();
		this.assignDate = assignDate;
		this.endDate = endDate;
		this.description = description;
		
	}

	
	
	
	
	
	
}
