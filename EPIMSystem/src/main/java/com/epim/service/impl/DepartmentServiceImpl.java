package com.epim.service.impl;

import com.epim.entity.Department;
import com.epim.mapper.DepartmentMapper;
import com.epim.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper mapper;

    public Department findById(String id) {
        return this.mapper.findById(id);
    }

    public List<Department> findAll() {
        return this.mapper.findAll();
    }

    public void insert(Department object) {
        this.mapper.insert(object);
    }

    public void update(Department object) {
        this.mapper.update(object);
    }

    public void delete(String id) {
        this.mapper.deleteById(id);
    }
}
