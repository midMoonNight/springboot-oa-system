package com.example.demo.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.domain.Nationality;
import com.example.demo.employee.repositoty.NationalityRepository;

@Service
public class NationalityService implements INationalityService {
	@Autowired
	private NationalityRepository nationalityRepository;
	
	@Override
	public void save(Nationality nationality) {
		nationalityRepository.save(nationality);
	}

	@Override
	public void deleteById(int id) {
		nationalityRepository.deleteById(id);
	}

	@Override
	public Optional<Nationality> findById(int id) {
		return nationalityRepository.findById(id);
	}

}
