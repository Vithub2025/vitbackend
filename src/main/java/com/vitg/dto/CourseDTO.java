package com.vitg.dto;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class CourseDTO {

	private int id;
	private String name;
	private String status;
	private String description;
	@Lob
	private byte[] image;

}