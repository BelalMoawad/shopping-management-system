package com.shopping.base.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity <ID extends Number> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;
	
	private Integer statusCode;
	
	@Column(updatable = false)
	private LocalDate createdDate;
	
	@Column(updatable = false)
	private String createdUser;
	
	private LocalDate modifiedDate;

	private String modifiedUser;

}
