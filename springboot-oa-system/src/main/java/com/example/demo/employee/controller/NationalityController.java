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
import com.example.demo.employee.domain.Nationality;
import com.example.demo.employee.service.INationalityService;

@RestController
@RequestMapping("/nationality")
public class NationalityController {
	@Autowired
	private INationalityService nationalityService;
	
	@PostMapping
	public ExtAjaxResponse save(@RequestBody Nationality nationality) {
		try {
			if (nationality.getNationalityName() != null) {
				nationalityService.save(nationality);
			}
			return new ExtAjaxResponse(true, "保存成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "保存失败!");
		}
	}
	
	@DeleteMapping(value= "{id}")
	public ExtAjaxResponse delete(@PathVariable("id") int id) {
		try {
			nationalityService.deleteById(id);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	
	@PutMapping(value="{id}")
	public ExtAjaxResponse update(@PathVariable("id") int id,@RequestBody Nationality nationality) {
		try {
			Nationality entity = nationalityService.findById(id).get();
			BeanUtils.copyProperties(nationality, entity);
			nationalityService.save(entity);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	
	@GetMapping(value="{id}")
	public Nationality findById(@PathVariable("id") int id) {
		return nationalityService.findById(id).get();
	}
}
