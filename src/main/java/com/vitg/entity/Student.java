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

@Data
@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private static long serialVersionUID = -5583968848579257151L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//@Column ( name = "id")
	private int id;
	
	//@Column ( name = "name")
	private String name;
	
	//@Column ( name = "mobile_number" ,unique =true)
	private String mobileNumber;
	
	//@Column ( name = "email" )
	private String email;
	private String gender;

}
