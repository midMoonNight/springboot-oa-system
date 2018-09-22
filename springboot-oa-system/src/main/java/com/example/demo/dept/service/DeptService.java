package com.example.demo.dept.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dept.domain.Dept;
import com.example.demo.dept.domain.DeptStatus;
import com.example.demo.dept.repository.DeptRepository;

@Service
public class DeptService implements IDeptService {
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public void save(Dept dept) {
		deptRepository.save(dept);
	}

	@Override
	public void saveAll(List<Dept> depts) {
		deptRepository.saveAll(depts);
	}

	@Override
	public void deleteById(Long id) {
		Dept dept = deptRepository.findById(id).get();
		dept.setDeptStatus(DeptStatus.disable);
		deptRepository.save(dept);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idList = new ArrayList<>(Arrays.asList(ids));	
		List<Dept> depts = (List<Dept>) deptRepository.findAllById(idList);
		for (Dept dept : depts) {
			dept.setDeptStatus(DeptStatus.disable);
		}
		deptRepository.saveAll(depts);
	}

	@Override
	public Optional<Dept> findById(Long id) {
		return deptRepository.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		return (List<Dept>) deptRepository.findAll();
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
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable) {
		return deptRepository.findAll(spec, pageable);
	}

}
