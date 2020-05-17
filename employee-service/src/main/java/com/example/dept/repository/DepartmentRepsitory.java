package com.example.dept.repository;

import entities.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepsitory extends CrudRepository<Department, String> {
}
