package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="employee_address")
public class EmployeeAddress implements Serializable{

	private static final long serialVersionUID = 4130758031076098234L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String addressLine;
	private String country;
	private String zipCode;
	private String state;
	private String city;
}
