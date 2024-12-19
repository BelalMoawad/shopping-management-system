package com.shopping.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.exception.ResourceNotFoundException;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseService<T, ID extends Number> {
	
	@Autowired
	private BaseRepository<T, ID> baseRepository;
	
	private final Class<T> entityType;

    protected BaseService(Class<T> entityType) {
        this.entityType = entityType;
    }
	
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	public T findById(ID id) {
		return baseRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException(getEntityName() + " not found with id: " + id));
	}

	public Optional<T> getById(ID id) {
		return baseRepository.findById(id);
	}

	public void deleteById(ID id) {
		if (!baseRepository.existsById(id)) {
            throw new ResourceNotFoundException(getEntityName() + " not found with id: " + id);
        }
		baseRepository.deleteById(id);	
	}

	public void deleteAll() {
		baseRepository.deleteAll();
	}
	
	 private String getEntityName() {
	        return entityType.getSimpleName();
	 }
	
}