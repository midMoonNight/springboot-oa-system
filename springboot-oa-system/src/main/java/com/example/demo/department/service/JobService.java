package com.example.demo.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.department.domain.Job;
import com.example.demo.department.repository.JobRepository;

@Service
public class JobService implements IJboService {
	@Autowired
	private JobRepository jobrepository;
	
	@Override
	public void save(Job job) {
		jobrepository.save(job);
	}

	@Override
	public void deleteById(Long id) {
		jobrepository.deleteById(id);
	}

	@Override
	public Optional<Job> findById(Long id) {
		return jobrepository.findById(id);
	}

	@Override
	public List<Job> findAll() {
		return (List<Job>) jobrepository.findAll();
	}

}
