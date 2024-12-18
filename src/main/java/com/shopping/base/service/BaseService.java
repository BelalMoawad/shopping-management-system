package com.shopping.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.base.repository.BaseRepository;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseService<T, ID extends Number> {
	
	@Autowired
	private BaseRepository<T, ID> baseRepository;
	
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	public T findById(ID id) {
		return baseRepository.findById(id).orElse(null);
	}

	public T getOne(ID id) {
		return baseRepository.getReferenceById(id);
	}

	public Optional<T> getById(ID id) {
		return baseRepository.findById(id);
	}

	public T insert(T entity) {
		return baseRepository.save(entity);
	}

	public T persist(T entity) {
		return baseRepository.saveAndFlush(entity);

	}

	public T update(T entity) {
		return baseRepository.save(entity);
	}

	public void deleteById(ID id) {
		baseRepository.deleteById(id);
	}

	public void deleteAll(List<ID> ids) {
		ids.forEach(id -> {
			baseRepository.deleteById(id);
		});
	}
	
}