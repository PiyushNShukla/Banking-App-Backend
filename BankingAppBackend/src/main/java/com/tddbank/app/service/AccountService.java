package com.tddbank.app.service;

import com.tddbank.app.dto.AccountResponseDTO;
import com.tddbank.app.dto.CreateAccountRequest;

public interface AccountService {
	AccountResponseDTO createAccount(Long userId, CreateAccountRequest request);
}
