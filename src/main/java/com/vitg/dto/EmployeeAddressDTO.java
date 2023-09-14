package com.vitg.dto;

import lombok.Data;

@Data
public class EmployeeAddressDTO {
	private int id;
	private String addressLine;
	private String country;
	private String zipcode;
	private String state;
	private String city;

}
