package com.epim.mapper;

import com.epim.entity.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    Leave findByParam(@Param("param")Leave leave);
}
