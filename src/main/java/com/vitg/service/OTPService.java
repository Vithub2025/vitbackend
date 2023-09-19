package com.vitg.service;

import com.vitg.dto.OTPResponseDTO;
import com.vitg.dto.PhoneVerificationDTO;
import com.vitg.entity.PhoneVerification;

public interface OTPService {

	int generateOTP();
	String generateVerificationRef();
	void sendOTP(String phoneNumber,String otp);
	PhoneVerification savePhoneVerification(PhoneVerification phoneVerification);
	boolean verifyOtp(PhoneVerificationDTO phoneVerificationDTO);
	boolean validateOtp(String verificationRef,String phoneNumber);
}
