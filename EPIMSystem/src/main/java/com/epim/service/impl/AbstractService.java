package com.epim.service.impl;

import com.epim.mapper.BaseMapper;
import com.epim.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbstractService<M extends BaseMapper<T>,T>  implements Service<T> {
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

    public void update(String id,T object) {
        this.mapper.update(id,object);
    }

    public void deleteById(String id) {
        this.mapper.deleteById(id);
    }
}
