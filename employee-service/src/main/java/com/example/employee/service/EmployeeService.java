package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.example.dept.repository.DepartmentRepsitory;
import com.example.employee.repository.EmployeeRepository;
import entities.Department;
import entities.Employee;
import model.EmployeeInfo;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    DozerBeanMapper dozerBeanMapper;

    EmployeeRepository employeeRepository;

    DepartmentRepsitory departmentRepsitory;

    public EmployeeService(final DozerBeanMapper dozerBeanMapper,
                           final EmployeeRepository theEmployeeRepository,
                           final DepartmentRepsitory theDepartmentRepsitory) {
        this.dozerBeanMapper = dozerBeanMapper;
        this.employeeRepository = theEmployeeRepository;
        this.departmentRepsitory = theDepartmentRepsitory;
    }

    Function<Iterable<Employee>, List<EmployeeInfo>> function
            = new Function<Iterable<Employee>, List<EmployeeInfo>>() {
        List<EmployeeInfo> employeeList = new ArrayList<>();

        @Override
        public List<EmployeeInfo> apply(Iterable<Employee> employees) {
            for (Employee e : employees) {
                employeeList.add(dozerBeanMapper.map(e, EmployeeInfo.class));
            }
            return employeeList;
        }
    };


    public void saveEmployee(EmployeeInfo employee) {

        Employee emp
                = dozerBeanMapper.map(employee, Employee.class);

        employee.getDeptIds().forEach(s -> {
            Optional<Department> departmentById = departmentRepsitory.findById(s);
            emp.getDepartments().add(departmentById.orElse(null));
        });

        employeeRepository.save(emp);
    }


    @Transactional
    public EmployeeInfo updateEmployeeNames(EmployeeInfo employee, String id) {
        return dozerBeanMapper.map(employeeRepository
                .updateFirstAndLastNameAndMiddleNameByEmpId(id, employee.getFirstName(), employee.getLastName(), employee.getMiddleName()), EmployeeInfo.class);
    }

    public List<EmployeeInfo> getAllEmployees() {
        List<EmployeeInfo> employees = function.apply(employeeRepository.findAll());
        return employees;

    }

    public EmployeeInfo getEmployeeById(final long id) {
        return dozerBeanMapper.map(employeeRepository.findById(id), EmployeeInfo.class);
    }

}
