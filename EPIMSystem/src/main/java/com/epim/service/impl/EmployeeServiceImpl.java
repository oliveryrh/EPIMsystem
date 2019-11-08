package com.epim.service.impl;

import com.epim.entity.Employee;
import com.epim.mapper.EmployeeMapper;
import com.epim.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper mapper;
    public Employee findById(String id) {
        return this.mapper.findById(id);
    }

    public List<Employee> findAll() {
        return this.mapper.findAll();
    }

    public void insert(Employee object) {
        this.mapper.insert(object);
    }

    public void update(Employee object) {
        this.mapper.update(object);
    }

    public void delete(String id) {
        this.mapper.deleteById(id);
    }
}
