package com.vitg.service;

import java.util.List;

import com.vitg.dto.CourseDTO;

public interface CourseService {
	
	CourseDTO getCourseById(int id);
	List<CourseDTO> getAllCourses();
	CourseDTO addCourse(CourseDTO courseDTO);

}