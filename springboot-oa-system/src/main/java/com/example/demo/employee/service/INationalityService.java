package com.example.demo.employee.service;

import java.util.Optional;

import com.example.demo.employee.domain.Nationality;

public interface INationalityService {
	public void save(Nationality nationality);
	public void deleteById(int id);
	public Optional<Nationality> findById(int id);
}
