package com.example.demo.department.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.department.domain.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

}
