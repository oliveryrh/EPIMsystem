package com.epim.mapper;

import com.epim.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance>{
    List<Attendance> findByEmployeeId(@Param("id")String employeeId);
}
