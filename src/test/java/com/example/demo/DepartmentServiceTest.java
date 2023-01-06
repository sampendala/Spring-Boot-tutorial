package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Department;
import com.example.demo.error.ErrorException;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.service.DepartmentService;

@DataJpaTest
class DepartmentServiceTest {
	
	
	@Autowired
	private DepartmentRepo depRepo;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		
		Department dept=Department.builder().departmentName("MME").departmentAddress("Ganidpet").departmentCode("007")
				.build();
		
		entityManager.persist(dept);
	}

	@Test
	public void DepartfetchById() throws ErrorException {
		
		Department found=
				depRepo.findById(1L).get();
		assertEquals(found.getDepartmentName(),"MME");
	}

}
