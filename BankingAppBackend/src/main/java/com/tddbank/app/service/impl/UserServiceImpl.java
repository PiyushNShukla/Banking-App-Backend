package com.tddbank.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tddbank.app.dto.AccountResponseDTO;
import com.tddbank.app.dto.UserProfileResponseDTO;
import com.tddbank.app.model.User;
import com.tddbank.app.repository.UserRepository;
import com.tddbank.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	public UserProfileResponseDTO getUserProfile(Long userId) {
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
		 UserProfileResponseDTO dto = new UserProfileResponseDTO();
	        dto.setId(user.getId());
	        dto.setFullName(user.getFullName());
	        dto.setEmail(user.getEmail());
	        dto.setPhoneNumber(user.getPhoneNumber());
	        dto.setAddress(user.getAddress());
	        dto.setPostalCode(user.getPostalCode());
	        dto.setDob(user.getDob());
	        
	        List<AccountResponseDTO> accounts = user.getAccounts()
	                .stream()
	                .map(account -> {
	                    AccountResponseDTO acc = new AccountResponseDTO();
	                    acc.setId(account.getId());
	                    acc.setAccountNumber(account.getAccountNumber());
	                    acc.setBalance(account.getBalance());
	                    acc.setAccountType(account.getAccountType().name());
	                    acc.setStatus(account.getStatus().name());
	                    return acc;
	                })
	                .toList();

	        dto.setAccounts(accounts);

	        return dto;
	}
	
}
