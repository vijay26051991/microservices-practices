package com.example.employee.controller;

import java.util.List;

import com.example.employee.service.EmployeeService;
import controller.AbstractController;
import model.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements AbstractController<EmployeeInfo> {

    @Autowired
    EmployeeService employeeService;

    @Override
    public void save(EmployeeInfo employee) {
        employeeService.saveEmployee(employee);
    }

    @Override
    public EmployeeInfo update(EmployeeInfo employee, String id) {
        return employeeService.updateEmployeeNames(employee, id);
    }

    @Override
    public List<EmployeeInfo> getAll() {
        return employeeService.getAllEmployees();
    }

    @Override
    public EmployeeInfo getById(String id) {
        return employeeService.getEmployeeById(Long.valueOf(id));
    }
}
