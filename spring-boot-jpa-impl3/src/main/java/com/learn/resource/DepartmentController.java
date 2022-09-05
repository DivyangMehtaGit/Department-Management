package com.learn.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.DepartmentDto;
import com.learn.dto.SuccessResponseDTO;
import com.learn.entity.Department;
import com.learn.service.DepartmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private ModelMapper modelMapper;

	// Annotation
	@Autowired
	private DepartmentService departmentService;

	// Save operation
	@PostMapping("/save")
	public DepartmentDto saveDepartment(@Validated @RequestBody Department department) {
		return modelMapper.map(departmentService.saveDepartment(department), DepartmentDto.class);
	}

	// Read operation
	@GetMapping("/list")
	public Page<DepartmentDto> fetchDepartmentList(Pageable pageable) {
		return departmentService.fetchDepartmentList(pageable);
	}

	// get operation
	@GetMapping("/get/{id}")
	public DepartmentDto getDepartment(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartment(departmentId);
	}

	// Update operation
	@PutMapping("/update/{id}")
	public DepartmentDto updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department, departmentId);
	}

	// Delete operation
	@DeleteMapping("/delete/{id}")
	public SuccessResponseDTO deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return new SuccessResponseDTO("Department deleted");
	}

}
