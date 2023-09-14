package com.vitg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "role")
public class EmployeeRole {
	private static final long serialVersionUID = 6373101192042570534L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column ( name = "ID")
	private int id;
	
	@Column ( name = "role_name" ,unique = true)
	private String rolename;
	
}
