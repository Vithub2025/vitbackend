package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.PhoneVerification;

@Repository
public interface PhoneVerificationRepository extends JpaRepository<PhoneVerification,String>{

	PhoneVerification findByPhoneNumber(String phoneNumber);
	PhoneVerification findByVerificationRef(String verificationRef);
	void deleteByVerificationRef(String verificationRef);
	PhoneVerification findByPhoneNumberAndOtp(String phoneNumber,String opt);
}
