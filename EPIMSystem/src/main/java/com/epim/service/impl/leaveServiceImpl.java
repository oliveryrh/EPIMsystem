package com.epim.service.impl;

import com.epim.entity.Leave;
import com.epim.mapper.LeaveMapper;
import com.epim.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class leaveServiceImpl implements LeaveService {
    @Autowired
    LeaveMapper mapper;
    public Leave findById(String id) {
        return this.mapper.findById(id);
    }

    public List<Leave> findAll() {
        return this.mapper.findAll();
    }

    public void insert(Leave object) {
        this.mapper.insert(object);
    }

    public void update(Leave object) {
        this.mapper.update(object);
    }

    public void delete(String id) {
        this.mapper.deleteById(id);
    }
}
