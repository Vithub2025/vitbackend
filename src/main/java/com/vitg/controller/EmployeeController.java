package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.EmployeeDTO;
import com.vitg.service.EmployeeService;

@RestController
@RequestMapping("employee")

public class EmployeeController  {
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable("id")int id) {
		EmployeeDTO employee =employeeService.getEmployeeById(id);
		return employee;
		
	}
	@GetMapping("/getAllEmployees")
	public List<EmployeeDTO> getAllEmployees() {
	return employeeService.getAllEmployees();
		
	}
	
	@PostMapping("/addEmployee")
	public EmployeeDTO addEmployee( @RequestBody EmployeeDTO employeeDTO) {
		return employeeService.addEmployee(employeeDTO);
		
	}
}
