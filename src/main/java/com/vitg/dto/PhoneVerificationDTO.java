package com.vitg.dto;

import lombok.Data;

@Data
public class PhoneVerificationDTO {

	private String phoneNumber;
	private String verificationRef;
	private String otp;
}