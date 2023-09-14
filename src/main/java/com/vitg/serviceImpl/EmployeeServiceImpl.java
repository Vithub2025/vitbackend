package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.EmployeeDTO;
import com.vitg.entity.Employee;
import com.vitg.repository.EmployeeRepository;
import com.vitg.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDTO getEmployeeById(int id) {   
	 Employee employee =employeeRepository.findById( id);
	 EmployeeDTO employeeDTO =modelMapper.map(employee, EmployeeDTO.class);
	 System.out.println(employeeDTO);
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> EmployeeList= employeeRepository.findAll();
		System.out.println(EmployeeList);
		List<EmployeeDTO> EmployeeListDTO= new ArrayList<> ();   
		
		for (Employee employee:EmployeeList) {
			EmployeeDTO employeeDTO=modelMapper.map(employee ,EmployeeDTO.class);
			EmployeeListDTO.add(employeeDTO);
			}
		return EmployeeListDTO;
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
	  Employee employee=modelMapper.map(employeeDTO, Employee.class);
	  Employee employeeResponce=employeeRepository.save(employee);
	  EmployeeDTO employeeDTOResponce=modelMapper.map(employeeResponce, EmployeeDTO.class);
		return employeeDTOResponce;
	}

}