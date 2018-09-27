package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.beans.Status;
import com.example.demo.department.domain.Department;
import com.example.demo.department.domain.Role;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.service.IRoleService;
import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.service.IEmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootOaSystemApplicationTests {
	
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IRoleService roleservice;
	
	
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
	
	@Test
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
		departmentService.saveAll(departments);
	}
	
	@Test
	public void departmentSaveOne() {
		Department department = new Department();
		department.setDepartment_name("department_name222");
		department.setDepartment_number("department_number222");
		department.setDuties("duties222");
		department.setIntroduction("introduction222");
		department.setCreate_time(new Date());
		departmentService.save(department);
	}
	
	@Test
	public void departmentTestUnique() {
		Department department = new Department();
		department.setDepartment_name("department_name1");
		department.setDepartment_number("department_number1");
		department.setDuties("duties");
		department.setIntroduction("introduction");
		department.setCreate_time(new Date());
		departmentService.save(department);
	}
	
	@Test
	public void departmentDelete() {
		//departmentService.deleteById(1L);
		Long[] ids = new Long[20];
		
		for(int i=2;i<12;i++) {
			ids[i-2] = (long) i;
		}
		departmentService.deleteAll(ids);
	}

	@Test
	public void departmentFind() {
		Department department = departmentService.findById(1L).get();
		System.out.println("department::"+department);
		List<Department> departments = departmentService.findAll();
		for (Department dept : departments) {
			System.out.println(dept);
		}
	}
	
	@Test
	public void roleSave() {
		Role role = new Role();
		role.setRole_name("role_name111");
		roleservice.save(role);
	}
	
	
	@Test
	public void roleFind() {
		Role role = roleservice.findById(1).get();
		System.out.println(role);
	}
	
	@Test
	public void EmployeeSaveTestPassword() {
		Employee employee = new Employee();
		employee.setAccount("account5555555555111");
		employeeService.save(employee);
		
		/*employee = employeeService.findById(1L).get();
		System.out.println(employee);*/
	}
	
	public void jobSave() {
		
	}
	
	public void educationSave() {
		
	}
	
	public void nationalitySave() {
		
	}
	
	/*public static void main(String[] args) {
		System.out.println("aaa");
		Random random = new Random();
		System.out.println(getStringRandom(6));
	}
*/
	//生成随机数字和字母,  
    public static String getStringRandom(int length) {  

        String val = "";  
        Random random = new Random();        
        //length为几位密码 
        for(int i = 0; i < length; i++) {          
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }
}
