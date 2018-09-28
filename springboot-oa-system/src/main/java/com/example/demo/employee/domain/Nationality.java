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
 * 国籍实体类，如果是中国国籍，则可以继续设置民族
 * @author midMoonNight
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude= "id")
@Entity
@Table(name="nationality")
public class Nationality {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//国籍
	private String nationalityName;
	//民族
	private String nation;
}
