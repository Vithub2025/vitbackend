package com.vitg.service;

import com.vitg.dto.OTPResponseDTO;

public interface AuthService {
	OTPResponseDTO sendOTP(String phoneNumber);
}
