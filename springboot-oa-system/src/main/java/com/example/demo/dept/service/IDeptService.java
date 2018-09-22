package com.example.demo.dept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dept.domain.Dept;

public interface IDeptService {
	public void save(Dept dept);
	public void saveAll(List<Dept> depts);
	
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Optional<Dept> findById(Long id);
	public List<Dept> findAll();
	
	public boolean existsById(Long id);
	public long count();
	//动态条件查询
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable);
}
