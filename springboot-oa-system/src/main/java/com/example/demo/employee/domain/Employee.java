package com.example.demo.employee.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	private Long id;
	private String account;
	private String password;
	//工资
	private Long wages;
}
