package com.vitg.dto;

import lombok.Data;

@Data
public class TrainerDTO {

    private int id;
    private String name;
	private String mobileNumber;
	private String email;
	private String course;
	private String subCourse;
	private String status;
	private BatchDTO batch;

}
