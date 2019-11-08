package com.epim.service.impl;

import com.epim.entity.Attendance;
import com.epim.mapper.AttendanceMapper;
import com.epim.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceMapper mapper;
    public Attendance findById(String id) {
        return this.mapper.findById(id);
    }

    public List<Attendance> findAll() {
        return this.mapper.findAll();
    }

    public void insert(Attendance object) {
        this.mapper.insert(object);
    }

    public void update(Attendance object) {
        this.mapper.update(object);
    }

    public void delete(String id) {
        this.mapper.deleteById(id);
    }
}
