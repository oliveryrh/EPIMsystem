package com.epim.mapper;

import com.epim.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
}
