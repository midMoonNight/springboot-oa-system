package com.example.demo.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.domain.Education;
import com.example.demo.employee.repositoty.EducationRepository;

@Service
public class EducationService implements IEducationService {
	@Autowired
	private EducationRepository educationRepository;
	
	@Override
	public void save(Education education) {
		educationRepository.save(education);
	}

	@Override
	public void deleteById(Long id) {
		educationRepository.deleteById(id);
	}

	@Override
	public Optional<Education> findById(Long id) {
		return educationRepository.findById(id);
	}

}
