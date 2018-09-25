package com.example.demo.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.employee.domain.Employee;

public interface IEmployeeService {
	public void save(Employee employee);
	public void saveAll(List<Employee> employees);
	
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Optional<Employee> findById(Long id);
	public List<Employee> findAll();
	
	public boolean existsById(Long id);
	public long count();
	//动态条件查询
	public Page<Employee> findAll(Specification<Employee> spec, Pageable pageable);
}
