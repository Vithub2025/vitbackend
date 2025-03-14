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
@Table(name="course")
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id", length = 1000)
	private int id;
	
	@Column(name = "name", length = 1000)
	private String name;

	@Column(name = "image", length = 1000)
	@Lob
	private byte[] image;
	
	@Column(name = "description", length = 1000)
	private String description;
	
	@Column(name = "status", length = 1000)
	private String status;
}