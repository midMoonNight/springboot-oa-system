package com.example.demo.department.service;

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
import com.example.demo.department.domain.Department;
import com.example.demo.department.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {
	@Autowired
	private DepartmentRepository deptRepository;

	@Override
	public void save(Department dept) {
		deptRepository.save(dept);
	}

	@Override
	public void saveAll(List<Department> depts) {
		deptRepository.saveAll(depts);
	}

	@Override
	public void deleteById(Long id) {
		Department dept = deptRepository.findById(id).get();
		if (dept != null) {
			dept.setDeptStatus(Status.disable);
		}
		deptRepository.save(dept);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idList = new ArrayList<>(Arrays.asList(ids));	
		List<Department> depts = (List<Department>) deptRepository.findAllById(idList);
		if (depts.size() >0) {
			for (Department dept : depts) {
				dept.setDeptStatus(Status.disable);
			}
		}
		deptRepository.saveAll(depts);
	}

	@Override
	public Optional<Department> findById(Long id) {
		return deptRepository.findById(id);
	}

	@Override
	public List<Department> findAll() {
		return (List<Department>) deptRepository.findAll();
	}

	@Override
	public boolean existsById(Long id) {
		return deptRepository.existsById(id);
	}

	@Override
	public long count() {
		return deptRepository.count();
	}

	@Override
	public Page<Department> findAll(Specification<Department> spec, Pageable pageable) {
		return deptRepository.findAll(spec, pageable);
	}

}
