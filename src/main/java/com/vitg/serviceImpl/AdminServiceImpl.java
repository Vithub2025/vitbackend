package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.RoleDTO;
import com.vitg.entity.Role;
import com.vitg.repository.RoleRepository;
import com.vitg.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	public RoleRepository roleRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Override
	public List<RoleDTO> getStaffRoles() {
		List<Role> roleList = roleRepository.getStaffRoles();
		List<RoleDTO> roleDTOList = new ArrayList<>();
		for(Role role:roleList) {
			RoleDTO roleDTO = modelMapper.map(role,RoleDTO.class);
			roleDTOList.add(roleDTO);
		}
		return roleDTOList;
	}

	@Override
	public List<RoleDTO> getAllRoles() {
		List<Role> roleList = roleRepository.findAll();
		List<RoleDTO> roleDTOList = new ArrayList<>();
		for(Role role:roleList) {
			RoleDTO roleDTO = modelMapper.map(role,RoleDTO.class);
			roleDTOList.add(roleDTO);
		}
		return roleDTOList;
	}

}
