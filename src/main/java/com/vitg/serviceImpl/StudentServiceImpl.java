package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.StudentDTO;
import com.vitg.entity.Student;

import com.vitg.repository.StudentRepository;
import com.vitg.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public StudentDTO getStudentById(int id) {
		Student student = studentRepository.findById(id);
		StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
		System.out.println(studentDTO);
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> studentList=studentRepository.findAll();

		List<StudentDTO>studentListDTO=new ArrayList<>();
		for (Student student :studentList ) {

			StudentDTO studentDTO=modelMapper.map(student,StudentDTO.class);
			studentListDTO.add(studentDTO);
		}
		return studentListDTO;
	}

	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) {
		System.out.println("48"+studentDTO);
		Student student = modelMapper.map(studentDTO,Student.class);
		Student studentResponce = studentRepository.save(student);
		StudentDTO  studentDTOResponce = modelMapper.map(studentResponce, StudentDTO.class);
		return studentDTOResponce;
	}


}
