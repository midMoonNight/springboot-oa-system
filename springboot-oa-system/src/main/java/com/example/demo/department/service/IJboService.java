package com.example.demo.department.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.department.domain.Job;

public interface IJboService {
	public void save(Job job);
	public void deleteById(Long id);
	public Optional<Job> findById(Long id);
	public List<Job> findAll();
	
}
