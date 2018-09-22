package com.example.demo.dept.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dept.domain.Dept;

@Repository
public interface DeptRepository extends PagingAndSortingRepository<Dept, Long>,JpaSpecificationExecutor<Dept> {
	
}
