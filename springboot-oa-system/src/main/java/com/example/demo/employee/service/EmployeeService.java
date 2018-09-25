package com.example.demo.employee.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.common.beans.Status;
import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.repositoty.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public void save(Employee employee) {
		employeerepository.save(employee);
	}

	@Override
	public void saveAll(List<Employee> employees) {
		employeerepository.saveAll(employees);
	}

	@Override
	public void deleteById(Long id) {
		Employee employee = employeerepository.findById(id).get();
		if (employee != null) {
			employee.setStatus(Status.disable);
		}
		//要测试是否需要重新save一遍
		employeerepository.save(employee);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idList = new ArrayList<>(Arrays.asList(ids));	
		List<Employee> employees = (List<Employee>) employeerepository.findAllById(idList);
		if (employees.size() >0) {
			for (Employee employee : employees) {
				employee.setStatus(Status.disable);
			}
		}
		//要测试是否需要重新save一遍
		employeerepository.saveAll(employees);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeerepository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeerepository.findAll();
	}

	@Override
	public boolean existsById(Long id) {
		return employeerepository.existsById(id);
	}

	@Override
	public long count() {
		return employeerepository.count();
	}

	@Override
	public Page<Employee> findAll(Specification<Employee> spec, Pageable pageable) {
		return employeerepository.findAll(spec, pageable);
	}

}
