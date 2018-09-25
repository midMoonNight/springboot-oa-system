package com.example.demo.department.domain;

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
 * 角色实体类，用于设置员工的权限
 * @author midMoonNight
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude= "id")
@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int role_name;
}
