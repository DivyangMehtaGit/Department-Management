package com.learn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.learn.dto.DepartmentDto;
import com.learn.entity.Department;

public interface DepartmentService {

	// Save operation
	Department saveDepartment(Department department);

	// Read operation
	Page<DepartmentDto> fetchDepartmentList(Pageable pageable);

	// Update operation
	DepartmentDto updateDepartment(Department department, Long departmentId);

	// Delete operation
	void deleteDepartmentById(Long departmentId);

	// Get operation
	DepartmentDto getDepartment(Long departmentId);

}
