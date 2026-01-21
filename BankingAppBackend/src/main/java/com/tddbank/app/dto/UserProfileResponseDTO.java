package com.tddbank.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserProfileResponseDTO {
	private Long id;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String address;
	private String postalCode;
	private String dob;
	private List<AccountResponseDTO> accounts;
}
