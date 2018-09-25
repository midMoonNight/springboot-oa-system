package com.example.demo;

import java.util.Date;

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
		Department department = new Department();
		//2L,"department","123456","jianjie","zhizhe",new Date(),Status.activity
		department.setDepartment_name("department_name");
		department.setDepartment_number("department_number");
		department.setDuties("duties");
		department.setIntroduction("introduction");
		department.setCreate_time(new Date());
		departmentService.save(department);
	}

}
