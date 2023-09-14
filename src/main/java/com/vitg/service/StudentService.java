package com.vitg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vitg.dto.StudentDTO;
@Service
public interface StudentService {

	StudentDTO getStudentById(int id);
	List<StudentDTO> getAllStudents();
	StudentDTO addStudent(StudentDTO studentDTO);

}