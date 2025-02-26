package com.vitg.service;

import java.util.List;

import com.vitg.dto.RoleDTO;

public interface AdminService {
	List<RoleDTO> getStaffRoles();
	List<RoleDTO> getAllRoles();
}