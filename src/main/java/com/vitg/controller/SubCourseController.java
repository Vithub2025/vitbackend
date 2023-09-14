package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.SubCourseDTO;
import com.vitg.service.SubCourseService;

@RestController
@RequestMapping("/api/subCourse")
public class SubCourseController {
	
	@Autowired
	private SubCourseService subcourseservice;
	
	@PostMapping("/addSubCourse")
	public ResponseEntity<SubCourseDTO> addSubCourse(@RequestBody SubCourseDTO subCourseDTO){
		SubCourseDTO subcourseData = subcourseservice.addSubCourse(subCourseDTO);
		return new ResponseEntity<>(subcourseData, HttpStatus.CREATED);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubCourseDTO> getSubCourseById(@PathVariable int id){
		SubCourseDTO subcourseData = subcourseservice.getSubCourseById(id);
		return new ResponseEntity<>(subcourseData, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<SubCourseDTO>> getAllSubCourses(){
		List<SubCourseDTO> allSubCourses = subcourseservice.getAllSubCourses();
		return new ResponseEntity<>(allSubCourses, HttpStatus.OK);
	}
}
