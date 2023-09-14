package com.vitg.dto;

import lombok.Data;

@Data
public class BatchDTO {
	
	private int id;
	private String batchCode;
	private String batchName;
	private String trainer;
	private String status;
	private String startDate;
	private String endDate;
	private String course;
	private String subCourse;
	private String fee;
	private String organizer;
	private String description;
	private String demoLink;

}