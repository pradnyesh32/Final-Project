 package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	
	
	private LocalDate complaintDate;
	
	private String descriptions;
	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ComplaintStatus status;
	
	
	private LocalDate resolveDate;
	
	@ManyToOne
	@JsonIgnore
	private Owner owner;
	
	@ManyToOne
	@JsonIgnore
	private Tenant tenant;
	
	@ManyToOne
	@JsonIgnore
	private Secretary secretary;
	
	@ManyToOne
	@JsonIgnore
	private MaintainanceTeam maintainanceTeam;

	public Complaint(String descriptions) {
		super();
		this.descriptions = descriptions;
		this.complaintDate=LocalDate.now();
		this.status = ComplaintStatus.PENDING;
		
	}
	
	
	
	
	


	
	
	
	
	
	
	

}
