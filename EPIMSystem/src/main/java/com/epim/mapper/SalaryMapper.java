package com.epim.mapper;

import com.epim.entity.Salary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryMapper extends BaseMapper<Salary> {
    List<Salary> findAll();
}
