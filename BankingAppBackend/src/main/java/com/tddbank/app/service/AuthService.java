package com.tddbank.app.service;

import java.math.BigDecimal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tddbank.app.dto.LoginRequest;
import com.tddbank.app.dto.LoginResponse;
import com.tddbank.app.dto.SignupRequest;
import com.tddbank.app.model.Account;
import com.tddbank.app.model.User;
import com.tddbank.app.repository.AccountRepository;
import com.tddbank.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	

	    private final UserRepository userRepository;
	    private final AccountRepository accountRepository;
	    private final PasswordEncoder passwordEncoder;

	    public void signup(SignupRequest request) {

	        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
	            throw new RuntimeException("Email already registered");
	        }

	        User user = new User();
	        user.setFullName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        user.setPostalCode(request.getPinCode());
	        user.setDob(request.getDob());

	        userRepository.save(user);

	        Account account = new Account();
	        account.setAccountNumber("ACC" + System.currentTimeMillis());
	        account.setBalance(BigDecimal.ZERO);
	        account.setUser(user);

	        accountRepository.save(account);
	    }

	    public LoginResponse login(LoginRequest request) {

	        User user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

	        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	            throw new RuntimeException("Invalid credentials");
	        }

	        return new LoginResponse(user.getId(), "Login successful");
	    }
	

}
