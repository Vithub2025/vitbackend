package com.vitg.entity;

import java.io.Serializable;

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
public class Student implements Serializable{

	private static final long serialVersionUID = 4130758031076098234L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String mobileNumber;
	private String email;
	private String gender;

}
