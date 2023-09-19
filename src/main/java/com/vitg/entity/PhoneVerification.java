package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="phone_verification")
public class PhoneVerification implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String phoneNumber;
	private String verificationRef;
	private String otp;
	private long expiryTime;
}
