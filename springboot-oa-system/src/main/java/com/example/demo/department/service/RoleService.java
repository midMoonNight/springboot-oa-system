package com.example.demo.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.department.domain.Role;
import com.example.demo.department.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void deleteById(int id) {
		roleRepository.findById(id);
	}

	@Override
	public Optional<Role> findById(int id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}
	
}
