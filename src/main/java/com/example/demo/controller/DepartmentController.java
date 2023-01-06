package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.ErrorException;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	private final Logger log=LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department dept) {
		log.info("Inside of the Save Department");
		return deptService.saveDepartment(dept);
		
	}
	@GetMapping("/departments")
	public List<Department> fetchAllRecords() {
		return deptService.fetchAllRecords();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchById(@PathVariable("id") long id) throws ErrorException {
		return deptService.fetchById(id);
		
	}

}
