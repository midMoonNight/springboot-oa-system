package com.example.demo.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.beans.BeanUtils;
import com.example.demo.common.web.ExtAjaxResponse;
import com.example.demo.common.web.ExtjsPageRequest;
import com.example.demo.dept.domain.Dept;
import com.example.demo.dept.domain.dto.DeptQueryDTO;
import com.example.demo.dept.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private IDeptService deptService;
	
	
	/**
	 * 增加一个部门
	 */
	@PostMapping
	public ExtAjaxResponse save(@RequestBody Dept dept) {
		try {
			if (!"".equals(dept.getName()) && dept.getName() != null) {
				deptService.save(dept);
			}
			return new ExtAjaxResponse(true, "保存成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "保存失败!");
		}
	}
	/**
	 * 删除一个部门
	 */
	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) {
		try {
			deptService.deleteById(id);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	/**
	 * 批量删除部门
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) {
		try {
			if (ids != null) {
				deptService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true, "批量删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "批量删除失败!");
		}
	}
	
	/**
	 * 修改部门信息
	 */
	@PutMapping(value="{id}")
	public ExtAjaxResponse update(@PathVariable("id") Long id,@RequestBody Dept dept) {
		try {
			Dept entity = deptService.findById(id).get();
			BeanUtils.copyProperties(entity, dept);
			deptService.save(entity);
			
			return new ExtAjaxResponse(true, "修改成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "修改失败!");
		}
	}
	/**
	 * 查找一个部门
	 */
	@GetMapping(value="{id}")
	public Dept findById(@PathVariable("id") Long id) {
		return deptService.findById(id).get();		
	}
	/**
	 * 分页查询所有部门
	 */
	@GetMapping
	public Page<Dept> findPage(DeptQueryDTO deptQueryDTO,ExtjsPageRequest pageRequest) {
		return deptService.findAll(DeptQueryDTO.getWhereClause(deptQueryDTO), pageRequest.getPageable());
	}
}
