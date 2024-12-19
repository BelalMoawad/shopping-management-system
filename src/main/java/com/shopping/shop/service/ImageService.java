package com.shopping.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Image;
import com.shopping.shop.exception.ResourceNotFoundException;
import com.shopping.shop.repository.ImageRepository;

@Service
public class ImageService extends BaseService<Image, Long>{
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ProductService productService;
	
	public ImageService() {
		super(Image.class);
	}
	
	public Image insert(Image image) {
		if (image.getProduct() != null && image.getProduct().getId() != null) {
			image.setProduct(productService.findById(image.getProduct().getId()));
	    }
		return imageRepository.save(image);
	}
	
	public Image update(Image image) {
		Image existingImage = imageRepository.findById(image.getId()).orElseThrow(() -> 
        	new ResourceNotFoundException("Image not found with id: " + image.getId()));
	    // Update existing image details
	    existingImage.setFileName(image.getFileName());
	    existingImage.setImagePath(image.getImagePath());
	    if (existingImage.getProduct() != null && existingImage.getProduct().getId() != null) {
	    	existingImage.setProduct(productService.findById(existingImage.getProduct().getId()));
	    }
	    
	    return imageRepository.save(existingImage);
	}
	
	public List<Image> findByProductId(Long id) {
		return imageRepository.findByProductId(id);
	}
	
}
