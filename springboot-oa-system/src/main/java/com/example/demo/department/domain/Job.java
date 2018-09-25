package com.example.demo.department.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.employee.domain.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 职位实体类
 * @author midMoonNight
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude= {"id","department_job_id","employee_id"})
@Entity
@Table(name="job")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department_job_id;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="job_id")
	private Employee employee_id;
}
