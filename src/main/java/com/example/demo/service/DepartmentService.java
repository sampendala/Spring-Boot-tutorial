package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.ErrorException;

public interface DepartmentService {

	public Department saveDepartment(Department dept);

	public List<Department> fetchAllRecords();

	public Department fetchById(long id) throws ErrorException;

}
