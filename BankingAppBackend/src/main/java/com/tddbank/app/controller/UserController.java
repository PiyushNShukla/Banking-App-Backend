package com.tddbank.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tddbank.app.dto.UserProfileResponseDTO;
import com.tddbank.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	 private final UserService userService;

	    @GetMapping("/profile/{userId}")
	    public UserProfileResponseDTO getProfile(@PathVariable Long userId) {
	        return userService.getUserProfile(userId);
	                
	    }
}
