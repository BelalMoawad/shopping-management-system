package com.shopping.shop.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message) {
        super(message);
    }
}
