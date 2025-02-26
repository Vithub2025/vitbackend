package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student_material")
public class StudentMaterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id", length = 1000)
	private int id;
	
	@Column(name = "name", length = 1000)
	private String name;
	
	@Column(name = "student_material", length = 1000)
	@Lob
	private byte[] studentMaterial;
	
}