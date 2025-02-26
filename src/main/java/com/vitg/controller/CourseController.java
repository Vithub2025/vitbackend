 package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.CourseDTO;
import com.vitg.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
	
	@Autowired
	private  CourseService courseService;
	
	@GetMapping("/{id}")
	public CourseDTO getCourseById(@PathVariable  int id) {
		CourseDTO course =courseService.getCourseById(id);
		return course;
	}
	
	@GetMapping("/all")
	public List<CourseDTO> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PostMapping("/addCourse")
	public CourseDTO addCourse( @RequestBody  CourseDTO courseDTO) {
		CourseDTO courseDTOResponse = courseService.addCourse(courseDTO);
		return courseDTOResponse;
	}
}		





