package com.vitg.service;

import java.util.List;

import com.vitg.dto.SubCourseDTO;

public interface SubCourseService {
	
	public SubCourseDTO addSubCourse(SubCourseDTO subCourseDTO);
	public SubCourseDTO getSubCourseById(int id);
	public List<SubCourseDTO> getAllSubCourses();

}