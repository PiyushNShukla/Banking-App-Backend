package com.tddbank.app.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tddbank.app.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
	 private final AccountRepository accountRepository;

	    @GetMapping("/balance/{userId}")
	    public BigDecimal getBalance(@PathVariable Long userId) {
	        return accountRepository.findByUserId(userId)
	                .orElseThrow(() -> new RuntimeException("Account not found"))
	                .getBalance();
	    }
}
