package com.epim.service;

import com.epim.entity.Attendance;

import java.util.List;

public interface AttendanceService extends BaseService<Attendance> {
    public List<Attendance> findByEmployeeId(String id);
}
