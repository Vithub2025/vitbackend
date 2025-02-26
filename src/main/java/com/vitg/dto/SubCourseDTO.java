package com.vitg.dto;

import lombok.Data;

@Data
public class SubCourseDTO {

	private int id;
	private String name;
	private int durationDays;
	private int durationHours;
	private int fee;
	private String youtubeLink;
	private String syllabus;
	private String examCertification;
	private String overview;
	private String status;
	private CourseDTO course;
}
