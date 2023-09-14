package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitg.dto.CourseDTO;
import com.vitg.entity.Course;
import com.vitg.repository.CourseRepo;
import com.vitg.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CourseDTO getCourseById(int id) {
	Course course = courseRepo.findById(id);
	CourseDTO courseDTO=modelMapper.map(course,CourseDTO.class);
		return courseDTO ;
	}

	@Override
	public List<CourseDTO> getAllCourses() {
	List<Course> courseList=courseRepo.findAll();
	List<CourseDTO> courseListDTO=new ArrayList<>();
	for (Course course:courseList) {
		CourseDTO courseDTO=modelMapper.map(course, CourseDTO.class);
		courseListDTO.add(courseDTO);
	}
		return courseListDTO;
	}

	@Override
	public CourseDTO addCourse(CourseDTO courseDTO) {
		Course course =modelMapper.map(courseDTO, Course.class);
		Course courseResponce=courseRepo.save(course);
		CourseDTO courseDTOResponce=modelMapper.map(courseResponce, CourseDTO.class);
		return courseDTOResponce;
	}

}
