package com.example.demo.dept.domain;

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
@Table(name="dept")
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int number = 0;
	private String introduction;
	private String duties;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy/MM/dd hh:mm:ss",timezone="GMT+8")
	private Date createTime;
	@Enumerated(EnumType.STRING)
	private DeptStatus deptStatus = DeptStatus.activity;
}
