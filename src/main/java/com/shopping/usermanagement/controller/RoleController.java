package com.shopping.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.usermanagement.dto.RoleDto;
import com.shopping.usermanagement.entity.Role;
import com.shopping.usermanagement.mapper.RoleMapper;
import com.shopping.usermanagement.service.RoleService;


@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		List<RoleDto> roleDtos = roleMapper.map(roleService.findAll());
		return ResponseEntity.ok(roleDtos);
	}
	
}
