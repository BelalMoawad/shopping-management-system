package com.shopping.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.security.dto.AppUserDto;
import com.shopping.security.mapper.AppUserMapper;
import com.shopping.security.service.AppUserService;
import com.shopping.shop.dto.CartDto;


@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private AppUserMapper appUserMapper;
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		List<AppUserDto> appUserDtos = appUserMapper.map(appUserService.findAll());
		return ResponseEntity.ok(appUserDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		AppUserDto appUserDto = appUserMapper.map(appUserService.findById(id));
		return ResponseEntity.ok(appUserDto);
	}
}
