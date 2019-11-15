package com.epim.service.impl;

import com.epim.entity.Salary;
import com.epim.mapper.SalaryMapper;
import com.epim.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SalaryService")
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryMapper salaryMapper;

    public Salary findById(String id) {
        return this.salaryMapper.findById(id);
    }

    public List<Salary> findAll() {
        return salaryMapper.findAll();
    }

    public void insert(Salary object) {
        this.salaryMapper.insert(object);
    }

    public void update(Salary object) {
        this.salaryMapper.update(object);
    }

    public void delete(String id) { }


}
