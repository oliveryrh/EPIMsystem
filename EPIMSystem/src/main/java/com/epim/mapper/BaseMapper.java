package com.epim.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T> {

    T findById(@Param("id")String id);

    List<T> findAll();

    void insert(@Param("param")T obj);

    void update(@Param("id")String id,@Param("param")T obj);

    void deleteById(@Param("id")String id);
}
