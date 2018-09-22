package com.example.demo.dept.domain.dto;

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

import com.example.demo.dept.domain.Dept;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeptQueryDTO {
	
	private String name;
	//人数上限
	private int upperLimit = 0;
	//人数下限
	private int lowerLimit = 0;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date createTimeStart;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date createTimeEnd;
	
	@SuppressWarnings("serial")
	public static Specification<Dept> getWhereClause(final DeptQueryDTO deptQueryDTO) {
		return new Specification<Dept>() {
			@Override
			public Predicate toPredicate(Root<Dept> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicate = new ArrayList<>();

				if (StringUtils.isNotBlank(deptQueryDTO.getName())) {
					predicate.add(criteriaBuilder.like(root.get("name").as(String.class),
							"%" + deptQueryDTO.getName() + "%"));
				}
				if (deptQueryDTO.getLowerLimit()>0) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("number").as(Integer.class),
							deptQueryDTO.getLowerLimit()));
				}
				if (deptQueryDTO.getUpperLimit()>0) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("number").as(Integer.class),
							deptQueryDTO.getUpperLimit()));
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
