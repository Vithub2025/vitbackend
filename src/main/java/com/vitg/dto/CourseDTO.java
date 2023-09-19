package com.vitg.dto;

import lombok.Data;
@Data
public class CourseDTO {

	private int id;
	private String course;
	private String status;
	private String description;
	private byte[] image;

}