package com.example.dept.controller;

import java.util.List;

import com.example.dept.service.DepartmentService;
import controller.AbstractController;
import model.DepartmentInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentController implements AbstractController<DepartmentInfo> {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @Override
    public void save(DepartmentInfo departmentInfo) {

        departmentService.save(departmentInfo);
    }

    @Override
    public DepartmentInfo update(DepartmentInfo departmentInfo, String id) {
        return null;
    }

    @Override
    public List<DepartmentInfo> getAll() {
        return departmentService.getAllDepartments();
    }

    @Override
    public DepartmentInfo getById(String id) {
        return null;
    }
}
