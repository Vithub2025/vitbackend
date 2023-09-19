package com.vitg.serviceImpl;

import org.springframework.stereotype.Service;

import com.vitg.dto.OTPResponseDTO;
import com.vitg.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService{

	@Override
	public OTPResponseDTO sendOTP(String phoneNumber) {
		 Math.floor(100000 + Math.random() * 900000);
		return null;
	}

}
