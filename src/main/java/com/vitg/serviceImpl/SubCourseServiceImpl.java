package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.SubCourseDTO;
import com.vitg.entity.SubCourse;
import com.vitg.repository.SubCourseRepo;
import com.vitg.service.SubCourseService;

@Service
public class SubCourseServiceImpl implements SubCourseService {

	@Autowired
	private SubCourseRepo subCourseRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public SubCourseDTO addSubCourse(SubCourseDTO subCourseDTO) {
	     SubCourse subCourseData = modelMapper.map(subCourseDTO, SubCourse.class);
	     SubCourse subCourse = subCourseRepo.save(subCourseData);
	     SubCourseDTO subCourseDTOFinal = modelMapper.map(subCourse, SubCourseDTO.class);
	     return subCourseDTOFinal;
	}

	@Override
	public SubCourseDTO getSubCourseById(int id) {
		SubCourse subCourseData = subCourseRepo.findById(id);
		SubCourseDTO subCourseDTO = modelMapper.map(subCourseData, SubCourseDTO.class);
		return subCourseDTO;
	}

	@Override
	public List<SubCourseDTO> getAllSubCourses() {
		List<SubCourse> findAll = subCourseRepo.findAll();
		List<SubCourseDTO> subCourseDTOList = new ArrayList<>();
		for(SubCourse subCourse: findAll ) {
			SubCourseDTO subCourseDTO = modelMapper.map(subCourse, SubCourseDTO.class);
			subCourseDTOList.add(subCourseDTO);
		}
		return subCourseDTOList;
	}
}
