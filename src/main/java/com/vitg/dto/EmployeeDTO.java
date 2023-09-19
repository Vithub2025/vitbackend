package com.vitg.dto;

import com.vitg.entity.EmployeeAddress;
import com.vitg.entity.Role;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private int id;
	private String name;
	private String mobileNumber;
	private String email;
	private String aadhaar;
	private String gender;
	private byte[] profilePic;
	private byte[] aadhaarPic;
	private byte[] pancardPic;
	private EmployeeAddress address;
	private Role roleId;
	
	
	
	
	

}
