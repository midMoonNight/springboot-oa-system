package com.example.demo.employee.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@ToString(exclude= {"id","employees"})
@Entity
@Table(name="nationality")
public class Nationality {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//国籍
	private String nationality_name;
	//民族
	private String nation;
	//员工国籍/民族
	@OneToMany(cascade=CascadeType.ALL,mappedBy="nationality_id")
	private List<Employee> employees = new ArrayList<>();
}
