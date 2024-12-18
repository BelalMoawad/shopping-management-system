package com.shopping.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.usermanagement.dto.AppUserDto;
import com.shopping.usermanagement.mapper.AppUserMapper;
import com.shopping.usermanagement.service.AppUserService;


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
}
