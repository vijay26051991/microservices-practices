package com.example.employee.repository;

import entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Modifying()
    @Query("update Employee  e set e.firstName = ?2, e.lastName = ?3, e.middleName = ?4 where e.id = ?1")
    Employee updateFirstAndLastNameAndMiddleNameByEmpId(final String id,
                                                        final String firstName,
                                                        final String lastName,
                                                        final String MiddleName);
}
