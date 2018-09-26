package com.example.demo.employee.repositoty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.domain.Nationality;

@Repository
public interface NationalityRepository extends CrudRepository<Nationality, Integer> {

}
