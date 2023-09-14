package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
     Student findById(int id);
   
}
