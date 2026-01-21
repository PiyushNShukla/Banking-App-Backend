package com.tddbank.app.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountResponseDTO {
	 private Long id;
	 private String accountNumber;
	 private BigDecimal balance;
	 private String accountType;	    
	 private String status;
	 
}
