package com.epim.service.impl;

import com.epim.entity.Attendance;
import com.epim.mapper.AttendanceMapper;
import com.epim.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AttendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceMapper attendanceMapper;
    public Attendance findById(String id) {
        return this.attendanceMapper.findById(id);
    }

    public List<Attendance> findAll() {
        return this.attendanceMapper.findAll();
    }

    public void insert(Attendance object) {
        this.attendanceMapper.insert(object);
    }

    public void update(Attendance object) {
        this.attendanceMapper.update(object);
    }

    public void delete(String id) {
        this.attendanceMapper.deleteById(id);
    }
}
