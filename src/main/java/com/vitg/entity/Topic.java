package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="topic")
public class Topic implements Serializable{

	private static final long serialVersionUID = 4130758031076098234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	

	@Column(name = "name")
	private String name;

	@ManyToOne( targetEntity = SubCourse.class)
	@JoinColumn(name = "subcourse_id", referencedColumnName = "id")
	private SubCourse subCourse;

	@Column(name = "status")
	private String status;

}
