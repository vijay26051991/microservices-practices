package com.example.dept.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dept.repository.DepartmentRepsitory;
import entities.Department;
import model.DepartmentInfo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepsitory departmentRepository;

    @Autowired
    DozerBeanMapper dozerBeanMapper;


    public void save(final DepartmentInfo departmentInfo) {
        Department department = dozerBeanMapper.map(departmentInfo, Department.class);
        departmentRepository.save(department);
    }

    public List<DepartmentInfo> getAllDepartments() {
        Iterable<Department> all = departmentRepository.findAll();
        List<DepartmentInfo> departmentInfos = new ArrayList<>();
        for (Department department : all) {
            departmentInfos.add(dozerBeanMapper.map(department, DepartmentInfo.class));
        }
        return departmentInfos;
    }

}
