package com.example.demo.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.beans.BeanUtils;
import com.example.demo.common.web.ExtAjaxResponse;
import com.example.demo.common.web.ExtjsPageRequest;
import com.example.demo.employee.domain.Employee;
import com.example.demo.employee.domain.EmployeeQueryDTO;
import com.example.demo.employee.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	/**
	 * 增加一个员工
	 */
	@PostMapping
	public ExtAjaxResponse save(@RequestBody Employee employee) {
		try {
			/*if (!"".equals(employee.getName()) && employee.getName() != null) {
				employeeService.save(employee);
			}*/
			return new ExtAjaxResponse(true, "保存成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "保存失败!");
		}
	}
	/**
	 * 删除一个员工
	 */
	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) {
		try {
			employeeService.deleteById(id);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	/**
	 * 批量删除员工
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) {
		try {
			if (ids != null) {
				employeeService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true, "批量删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "批量删除失败!");
		}
	}
	
	/**
	 * 修改员工信息
	 */
	@PutMapping(value="{id}")
	public ExtAjaxResponse update(@PathVariable("id") Long id,@RequestBody Employee employee) {
		try {
			Employee entity = employeeService.findById(id).get();
			BeanUtils.copyProperties(entity, employee);
			employeeService.save(entity);
			
			return new ExtAjaxResponse(true, "修改成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "修改失败!");
		}
	}
	/**
	 * 查找一个员工
	 */
	@GetMapping(value="{id}")
	public Employee findById(@PathVariable("id") Long id) {
		return employeeService.findById(id).get();		
	}
	/**
	 * 分页查询所有员工
	 */
	@GetMapping
	public Page<Employee> findPage(EmployeeQueryDTO employeeQueryDTO,ExtjsPageRequest pageRequest) {
		return employeeService.findAll(EmployeeQueryDTO.getWhereClause(employeeQueryDTO), pageRequest.getPageable());
	}
}
