package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor   
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee implements Serializable{
	
	public static final long serialVersionUID = -5583968848579257151L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column (name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name= "mobile_number" , unique=true)
	private String mobileNumber;
	
	@Column(name= "email")
	private String email;
	
	@Column(name = "aadhaar" )
	private String aadhaar;
	
	@Column( name = "gender")
	private String gender;
	
	@Column( name = "profile_pic" , length = 1000)
	private byte[] profilePic;
	
	@Column( name = "aadhaar_pic" , length = Integer. MAX_VALUE , nullable =true)
	private byte[] aadhaarPic;
	
	@Column (name = "pan_card_pic" ,length = 1000)
	private byte[] pancardPic;
   
	@OneToOne (cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = Role.class) 
	@JoinColumn ( name = "role_id" , referencedColumnName = "id")
	private Role role;
	
	@OneToOne (cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = EmployeeAddress.class) 
	@JoinColumn ( name = "address_id" , referencedColumnName = "id")
	private EmployeeAddress addressTable;
	
	
	
	
	

}
