package com.vitg.dto;

import lombok.Data;

@Data
public class OTPResponseDTO {

	private String phoneNumber;
	private String verificationRef;
	private String statusMessage;
}
