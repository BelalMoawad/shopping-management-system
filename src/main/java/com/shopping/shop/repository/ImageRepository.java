package com.shopping.shop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.Image;

@Repository
public interface ImageRepository extends BaseRepository<Image, Long> {
	
	List<Image> findByProductId(Long id);
}
