package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.ImageDto;
import com.shopping.shop.entity.Image;

@Mapper(uses = {ProductMapper.class})
public interface ImageMapper extends BaseMapper<Image, ImageDto> {
	
}
