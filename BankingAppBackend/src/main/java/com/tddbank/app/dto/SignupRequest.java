package com.tddbank.app.dto;

import lombok.Data;

@Data
public class SignupRequest {
	   private String name;
	   private String email;
	   private String password;
	   private String pinCode;
	   private String dob;
	

}
