package com.example.demo.department.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.common.beans.Status;
import com.example.demo.employee.domain.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="id")
@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//部门名称
	private String department_name;
	//部门编号
	private String department_number;
	//部门简介
	private String introduction;
	//部门职责
	private String duties;
	//部门创建时间
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy/MM/dd hh:mm:ss",timezone="GMT+8")
	private Date create_time;
	//部门的状态，是还在使用的部门，还是已经废除的部门
	@Enumerated(EnumType.STRING)
	private Status deptStatus = Status.activity;
	//部门员工
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department_id")
	private List<Employee> employees = new ArrayList<>();
	//上级部门
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department_parent;
	//部门职位
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department_job_id")
	private List<Job> jobs = new ArrayList<>();
}
