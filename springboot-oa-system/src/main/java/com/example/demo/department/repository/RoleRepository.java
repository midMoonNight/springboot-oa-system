package com.example.demo.department.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.department.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
