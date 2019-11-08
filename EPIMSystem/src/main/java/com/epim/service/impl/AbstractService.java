package com.epim.service.impl;

import com.epim.mapper.BaseMapper;
import com.epim.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@org.springframework.stereotype.Service
public class AbstractService<M extends BaseMapper<T>,T>  implements BaseService<T> {
    @Autowired
    protected M mapper;

    public T findById(String id) {

        return this.mapper.findById(id);
    }

    public List<T> findAll() {
        return this.mapper.findAll();
    }
    public void insert(T object) {
        this.mapper.insert(object);
    }

    public void update(T object) {
        this.mapper.update(object);
    }

    public void delete(String id) {
        this.mapper.deleteById(id);
    }
}
