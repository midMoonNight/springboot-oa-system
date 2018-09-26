package com.example.demo.employee.service;

import java.util.Optional;

import com.example.demo.employee.domain.Education;

public interface IEducationService {
	public void save(Education education);
	public void deleteById(Long id);
	public Optional<Education> findById(Long id);
}
