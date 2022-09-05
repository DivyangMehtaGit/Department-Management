package com.learn.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.entity.Department;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
