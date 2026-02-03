package com.tddbank.app.service.impl;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.tddbank.app.dto.AccountResponseDTO;
import com.tddbank.app.dto.CreateAccountRequest;
import com.tddbank.app.model.Account;
import com.tddbank.app.model.User;
import com.tddbank.app.repository.AccountRepository;
import com.tddbank.app.repository.UserRepository;
import com.tddbank.app.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	private final UserRepository userRepository;
	private final AccountRepository accountRepository;
	
	@Override
	public AccountResponseDTO createAccount(Long userId, CreateAccountRequest request) {
		User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		Account account=new Account();
		account.setAccountType(Account.AccountType.valueOf(request.getAccountType()));
		account.setStatus(Account.AccountStatus.ACTIVE);
		account.setBalance(BigDecimal.ZERO);
		account.setUser(user);
		account.setAccountNumber("ACC"+System.currentTimeMillis());
		
		Account saved=accountRepository.save(account);
		
		AccountResponseDTO dto=new AccountResponseDTO();
		dto.setId(saved.getId());
		dto.setAccountNumber(saved.getAccountNumber());
		dto.setAccountType(saved.getAccountType().toString());
		dto.setStatus(saved.getStatus().toString());
		dto.setBalance(saved.getBalance());
		
		return dto;
	}
	

}
