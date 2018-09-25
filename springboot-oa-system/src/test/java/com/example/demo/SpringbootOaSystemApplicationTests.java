package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.beans.Status;
import com.example.demo.department.domain.Department;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.employee.service.IEmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootOaSystemApplicationTests {
	
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	public void contextLoads() {
		
		Department org1 = new Department();
		org1.setDepartment_number("D00001");
		org1.setDepartment_name("东莞理工学院");

		Department org2 = new Department();
		org2.setDepartment_number("D00002");
		org2.setDepartment_name("东莞理工学院计算机与网络安全学院");

		Department org3 = new Department();
		org3.setDepartment_number("D00003");
		org3.setDepartment_name("机械工程学院");

		Department org4 = new Department();
		org4.setDepartment_number("D00004");
		org4.setDepartment_name("国际学院");

		Department org5 = new Department();
		org5.setDepartment_number("D00021");
		org5.setDepartment_name("计算机科学与应用专业");

		Department org6 = new Department();
		org6.setDepartment_number("D00022");
		org6.setDepartment_name("软件工程专业");

		Department org7 = new Department();
		org7.setDepartment_number("D00023");
		org7.setDepartment_name("网络安全专业");
		
		org1.getChildrens().add(org2);
		org1.getChildrens().add(org3);
		org1.getChildrens().add(org4);

		org2.setDepartment_parent(org1);
		org3.setDepartment_parent(org1);
		org4.setDepartment_parent(org1);

		org2.getChildrens().add(org5);
		org2.getChildrens().add(org6);
		org2.getChildrens().add(org7);

		org5.setDepartment_parent(org2);
		org6.setDepartment_parent(org2);
		org7.setDepartment_parent(org2);
		
		departmentService.save(org1);
	}
	
	public void departmentListSave() {
		List<Department> departments = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Department department = new Department();
			department.setDepartment_name("department_name"+i);
			department.setDepartment_number("department_number"+i);
			department.setDuties("duties"+i);
			department.setIntroduction("introduction"+i);
			department.setCreate_time(new Date());
			departments.add(department);
		}
	}
	
	public void jobSave() {
		
	}
	
	public void roleSave() {
		
	}
	
	public void educationSave() {
		
	}
	
	public void nationalitySave() {
		
	}

}
