package com.example.demo.department.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.department.domain.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long>,JpaSpecificationExecutor<Department> {
	
}
