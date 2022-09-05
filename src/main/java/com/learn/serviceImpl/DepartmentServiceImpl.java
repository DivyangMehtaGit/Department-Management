package com.learn.serviceImpl;

//Importing required classes
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learn.dto.DepartmentDto;
import com.learn.entity.Department;
import com.learn.exception.DepartmentNotFoundException;
import com.learn.repository.DepartmentRepository;
import com.learn.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DepartmentRepository departmentRepository;

	// Save operation
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	// Read operation
	@Override
	public Page<DepartmentDto> fetchDepartmentList(Pageable pageable) {
		List<DepartmentDto> resultList = departmentRepository.findAll().stream()
				.map(dept -> modelMapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
		long count = resultList.size();
		return new PageImpl<>(resultList, pageable, count);
	}

	// Update operation
	@Override
	public DepartmentDto updateDepartment(Department department, Long departmentId) {
		Optional<Department> depDB = departmentRepository.findById(departmentId);
		if (depDB.isEmpty()) {
			throw new EmptyResultDataAccessException(String.format("No department exist with id %d", departmentId), 1);
		}
		department.setDepartmentId(departmentId);
		Department dept = departmentRepository.save(department);
		return modelMapper.map(dept, DepartmentDto.class);
	}

	// Delete operation
	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.findById(departmentId).orElseThrow(DepartmentNotFoundException::new);
		departmentRepository.deleteById(departmentId);
	}

	// Get operation
	@Override
	public DepartmentDto getDepartment(Long departmentId) {
		Optional<Department> depDB = departmentRepository.findById(departmentId);
		Department dept = depDB.orElseThrow(DepartmentNotFoundException::new);
		return modelMapper.map(dept, DepartmentDto.class);
	}

}
