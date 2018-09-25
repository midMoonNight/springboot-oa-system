package com.example.demo.employee.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.common.beans.Gender;
import com.example.demo.common.beans.Status;
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
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//员工帐号
	private String account;
	//员工密码
	private String password;
	//工资
	private int wages=0;
	//部门id
	private Long department_id;
	//角色（权限）id
	private Long role_id;
	//职位id
	private Long job_id;
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
	//员工民族
	private Long national_id;
	//员工学历
	private Long education_id;
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
}
