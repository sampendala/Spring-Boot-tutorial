package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.ErrorException;
import com.example.demo.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo deptRepo;

	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return deptRepo.save(dept);
	}

	@Override
	public List<Department> fetchAllRecords() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	@Override
	public Department fetchById(long id) throws ErrorException {
		// TODO Auto-generated method stub
		Optional<Department> department= deptRepo.findById(id);
		if(!department.isPresent()) {
			throw new ErrorException("Department not found");
		}
		return department.get();
	}

}
