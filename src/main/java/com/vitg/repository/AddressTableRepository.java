package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.EmployeeAddress;


@Repository
public interface AddressTableRepository  extends JpaRepository< EmployeeAddress , Integer>{
	
	 EmployeeAddress findById(int id);
	
	

}
