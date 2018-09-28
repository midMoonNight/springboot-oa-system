package com.example.demo.department.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentQueryDTO {
	
	private String departmentName;
	private String departmentNumber;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date createTimeStart;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date createTimeEnd;
	
	@SuppressWarnings("serial")
	public static Specification<Department> getWhereClause(final DepartmentQueryDTO deptQueryDTO) {
		return new Specification<Department>() {
			@Override
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicate = new ArrayList<>();

				if (StringUtils.isNotBlank(deptQueryDTO.getDepartmentName())) {
					predicate.add(criteriaBuilder.like(root.get("departmentName").as(String.class),
							"%" + deptQueryDTO.getDepartmentName() + "%"));
				}
				if (StringUtils.isNotBlank(deptQueryDTO.getDepartmentNumber())) {
					predicate.add(criteriaBuilder.like(root.get("departmentNumber").as(String.class),
							"%" + deptQueryDTO.getDepartmentNumber() + "%"));
				}
				if (null!=deptQueryDTO.getCreateTimeStart()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime").as(Date.class),
							deptQueryDTO.getCreateTimeStart()));
				}
				if (null!=deptQueryDTO.getCreateTimeEnd()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(Date.class),
							deptQueryDTO.getCreateTimeEnd()));
				}
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
	
}
