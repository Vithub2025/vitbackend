package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.SubCourse;
@Repository
public interface SubCourseRepo extends JpaRepository<SubCourse, Integer> {
	
	SubCourse findById(int id);
}
