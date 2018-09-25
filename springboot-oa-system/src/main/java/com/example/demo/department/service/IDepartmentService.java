package com.example.demo.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.department.domain.Department;

public interface IDepartmentService {
	public void save(Department dept);
	public void saveAll(List<Department> depts);
	
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Optional<Department> findById(Long id);
	public List<Department> findAll();
	
	public boolean existsById(Long id);
	public long count();
	//动态条件查询
	public Page<Department> findAll(Specification<Department> spec, Pageable pageable);
}
