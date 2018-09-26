package com.example.demo.employee.repositoty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.domain.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {

}
