package com.tddbank.app.service;

import com.tddbank.app.dto.UserProfileResponseDTO;


public interface UserService {
	UserProfileResponseDTO getUserProfile(Long userId);
}
