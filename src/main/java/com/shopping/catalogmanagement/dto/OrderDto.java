package com.shopping.catalogmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.shopping.base.dto.BaseDto;
import com.shopping.catalogmanagement.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto extends BaseDto<Long> {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date date ;
	
	private List<Product> products = new ArrayList<>();

}
