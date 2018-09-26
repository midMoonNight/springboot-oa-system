package com.example.demo.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.beans.BeanUtils;
import com.example.demo.common.web.ExtAjaxResponse;
import com.example.demo.employee.domain.Education;
import com.example.demo.employee.service.IEducationService;

@RestController
@RequestMapping("/education")
public class EducationController {
	@Autowired
	private IEducationService educationService;
	
	@PostMapping
	public ExtAjaxResponse save(@RequestBody Education education) {
		try {
			if (education.getEducation_name() != null) {
				educationService.save(education);
			}
			return new ExtAjaxResponse(true, "保存成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "保存失败!");
		}
	}
	
	@DeleteMapping(value= "{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) {
		try {
			educationService.deleteById(id);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	
	@PutMapping(value="{id}")
	public ExtAjaxResponse update(@PathVariable("id") Long id,@RequestBody Education education) {
		try {
			Education entity = educationService.findById(id).get();
			BeanUtils.copyProperties(education, entity);
			educationService.save(entity);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	
	@GetMapping(value="{id}")
	public Education findById(@PathVariable("id") Long id) {
		return educationService.findById(id).get();
	}
	
}
