package com.example.demo.employee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 教育经历实体类，主要是用于设置员工的学历
 * @author midMoonNight
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="id")
@Entity
@Table(name="education")
public class Education {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//学历
	private String education_name;
	//学校
	private String university;
	//学院
	private String institute;
	//专业
	private String major;
}
