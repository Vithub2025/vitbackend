package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.StudentDTO;
import com.vitg.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable ("id") int id) {
		StudentDTO student = studentService.getStudentById(id);
		return student;
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents(){
		return studentService.getAllStudents();

	}
	
 	@PostMapping("/addStudent")
	public StudentDTO addstudent(@RequestBody StudentDTO studentDTO) {
 		System.out.println("37"+studentDTO);
		return studentService.addStudent(studentDTO);

	}
 	



}