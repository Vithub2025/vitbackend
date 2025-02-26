package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.RoleDTO;
import com.vitg.entity.Role;
import com.vitg.repository.RoleRepository;
import com.vitg.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	public AdminService adminService;

	@GetMapping("/getAllRoles")
	public List<RoleDTO> getAllRoles() {
		return adminService.getAllRoles();
	}

	@GetMapping("/getStaffRoles")
	public List<RoleDTO> getStaffRoles() {
		return adminService.getStaffRoles();
	}
}
