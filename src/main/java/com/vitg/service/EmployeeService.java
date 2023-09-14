package com.vitg.service;

import java.util.List;

import com.vitg.dto.EmployeeDTO;

public interface EmployeeService  {
	
	EmployeeDTO getEmployeeById(int id);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

}
