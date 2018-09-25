package com.example.demo.employee.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.common.beans.Gender;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeQueryDTO {
	private String account;
	private int upperWages=0;
	private int lowerWages=0;
	private Long department_id;
	private Long job_id;
	private Gender gender;
	private String telphone;
	private String employee_name;
	private String address;
	private Long national_id;
	private Long education_id;
	
	public static Specification<Employee> getWhereClause(final EmployeeQueryDTO employeeQueryDTO){
		return new Specification<Employee>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unlikely-arg-type")
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicate = new ArrayList<>();
				
				if (StringUtils.isNoneBlank(employeeQueryDTO.getAccount())) {
					predicate.add(criteriaBuilder.like(root.get("account").as(String.class)
							, "%"+employeeQueryDTO.getAccount()+"%"));
				}
				if (employeeQueryDTO.getUpperWages() >0) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("wages").as(int.class)
							, employeeQueryDTO.getUpperWages()));
				}
				if (employeeQueryDTO.getLowerWages() >0) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("wages").as(int.class)
							, employeeQueryDTO.getLowerWages()));
				}
				if (employeeQueryDTO.getDepartment_id() >0) {
					predicate.add(criteriaBuilder.equal(root.get("department_id").as(Long.class)
							, employeeQueryDTO.getDepartment_id()));
				}
				if (employeeQueryDTO.getJob_id() >0) {
					predicate.add(criteriaBuilder.equal(root.get("job_id").as(Long.class)
							, employeeQueryDTO.getJob_id()));
				}
				if (employeeQueryDTO.getGender() != null && !employeeQueryDTO.getGender().equals("")) {
					predicate.add(criteriaBuilder.equal(root.get("gender").as(Gender.class)
							, employeeQueryDTO.getGender()));
				}
				if (StringUtils.isNoneBlank(employeeQueryDTO.getTelphone())) {
					predicate.add(criteriaBuilder.like(root.get("telphone").as(String.class)
							, "%"+employeeQueryDTO.getTelphone()+"%"));
				}
				if (StringUtils.isNoneBlank(employeeQueryDTO.getEmployee_name())) {
					predicate.add(criteriaBuilder.like(root.get("employee_name").as(String.class)
							, "%"+employeeQueryDTO.getEmployee_name()+"%"));
				}
				if (StringUtils.isNoneBlank(employeeQueryDTO.getAddress())) {
					predicate.add(criteriaBuilder.like(root.get("address").as(String.class)
							, "%"+employeeQueryDTO.getAddress()+"%"));
				}
				if (employeeQueryDTO.getNational_id() >0) {
					predicate.add(criteriaBuilder.equal(root.get("national_id").as(Long.class)
							, employeeQueryDTO.getNational_id()));
				}if (employeeQueryDTO.getEducation_id() >0) {
					predicate.add(criteriaBuilder.equal(root.get("education_id").as(Long.class)
							, employeeQueryDTO.getEducation_id()));
				}
				
				Predicate[] pre = new Predicate[predicate.size()];
				
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
