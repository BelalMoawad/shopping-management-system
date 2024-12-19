package com.shopping.shop.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.shop.dto.ImageDto;
import com.shopping.shop.entity.Image;
import com.shopping.shop.mapper.ImageMapper;
import com.shopping.shop.service.ImageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/image")
@RequiredArgsConstructor
public class ImageController {
	
	private final ImageService imageService;

	private final ImageMapper imageMapper;
	
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Image image) {
		ImageDto imageDto = imageMapper.map(imageService.insert(image));
		return ResponseEntity.ok(imageDto);
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Image image) {
	    ImageDto imageDto = imageMapper.map(imageService.update(image));
	    return ResponseEntity.ok(imageDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByProductId(@PathVariable Long id) {
		List<ImageDto> imageDto = imageMapper.map(imageService.findByProductId(id));
		return ResponseEntity.ok(imageDto);
	}

}
