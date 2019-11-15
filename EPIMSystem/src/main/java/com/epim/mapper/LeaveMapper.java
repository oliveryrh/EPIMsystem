package com.epim.mapper;

import com.epim.entity.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    List<Leave> findByParam(@Param("param")Leave leave);
}
