package com.vitg.dto;

import com.vitg.entity.EmployeeAddress;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private int id;
	private String name;
	private String mobileNumber;
	private String email;
	private String aadhaar;
	private String gender;
	private byte[]profilePic;
	private byte[] aadhaaePic;
	private byte[]pancardPic;
	private EmployeeAddress address;
	private String roleId;
	
	
	
	
	

}
