package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{

}
