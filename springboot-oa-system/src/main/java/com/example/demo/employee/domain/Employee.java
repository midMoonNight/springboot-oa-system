package com.example.demo.employee.domain;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.common.beans.Gender;
import com.example.demo.common.beans.Status;
import com.example.demo.department.domain.Department;
import com.example.demo.department.domain.Job;
import com.example.demo.department.domain.Role;
import com.example.demo.employee.util.EmployeeRadomPassword;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 员工实体类
 * @author midMoonNight
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude= {"id","department_id","role_id","job_id","nationality_id","education_id","subordinate"})
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//员工帐号
	private String account;
	//员工密码
	private String password = EmployeeRadomPassword.getStringRandom(6);
	//工资
	private int wages=0;
	//部门id
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department_id;
	//角色（权限）id
	@OneToOne(cascade=CascadeType.ALL)
	private Role role_id;
	//职位id
	@OneToOne(cascade=CascadeType.ALL)
	private Job job_id;
	//性别
	@Enumerated(EnumType.STRING)
	private Gender gender;
	//电话
	private String telphone;
	//员工姓名
	private String employee_name;
	//员工地址
	private String address;
	//员工身份证
	private String id_card;
	//员工国籍
	@ManyToOne(cascade=CascadeType.ALL)
	private Nationality nationality_id;
	//员工学历
	@OneToOne(cascade=CascadeType.ALL)
	private Education education_id;
	//员工邮箱
	private String email;
	//入职时间
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy/MM/dd hh:mm:ss",timezone="GMT+8")
	private Date entry_time;
	//离职时间
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy/MM/dd hh:mm:ss",timezone="GMT+8")
	private Date separation_time;
	//设置员工的状态值，是在职的还是离职的
	@Enumerated(EnumType.STRING)
	private Status status = Status.activity;
	//上级领导
	@ManyToOne(cascade=CascadeType.ALL)
	private Employee employee_leader;
	//下属
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee_leader")
	private List<Employee> subordinate = new ArrayList<>();
}
