package com.tddbank.app.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tddbank.app.dto.AccountResponseDTO;
import com.tddbank.app.dto.CreateAccountRequest;
import com.tddbank.app.repository.AccountRepository;
import com.tddbank.app.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
	 private final AccountRepository accountRepository;
	 private final AccountService accountService;

	    @GetMapping("/balance/{userId}")
	    public BigDecimal getBalance(@PathVariable Long userId) {
	        return accountRepository.findByUserId(userId)
	                .orElseThrow(() -> new RuntimeException("Account not found"))
	                .getBalance();
	    }
	    
	    @PostMapping("/user/{userId}")
	    public ResponseEntity<AccountResponseDTO> createAccount(
	    		@PathVariable Long userId, @RequestBody CreateAccountRequest request )
	    {
	    	return ResponseEntity.status(HttpStatus.CREATED)
	    			.body(accountService.createAccount(userId, request));
	    	
	    }
}
