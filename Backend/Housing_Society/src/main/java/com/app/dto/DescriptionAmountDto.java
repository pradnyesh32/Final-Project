package com.app.dto;

import org.springframework.stereotype.Component;

import com.app.pojo.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DescriptionAmountDto {
	
	private String description;
	private double amount;

}
