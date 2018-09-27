package com.example.demo.department.controller;

import org.apache.commons.lang3.StringUtils;
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
import com.example.demo.department.domain.Job;
import com.example.demo.department.service.IJboService;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	private IJboService jobService;
	
	@PostMapping
	public ExtAjaxResponse save(@RequestBody Job job) {
		try {
			if (StringUtils.isNotBlank(job.getName()) && job.getDepartment_job_id() != null) {
				jobService.save(job);
			}
			return new ExtAjaxResponse(true, "保存成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "保存失败!");
		}
	}
	
	@DeleteMapping(value= "{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) {
		try {
			jobService.deleteById(id);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	
	@PutMapping(value="{id}")
	public ExtAjaxResponse update(@PathVariable("id") Long id,@RequestBody Job job) {
		try {
			Job entity = jobService.findById(id).get();
			BeanUtils.copyProperties(job, entity);
			jobService.save(entity);
			return new ExtAjaxResponse(true, "删除成功!");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "删除失败!");
		}
	}
	
	@GetMapping(value="{id}")
	public Job findById(@PathVariable("id") Long id) {
		return jobService.findById(id).get();
	}

}
