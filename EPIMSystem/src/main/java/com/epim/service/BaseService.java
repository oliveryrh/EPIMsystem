package com.epim.service;

import java.util.List;

@org.springframework.stereotype.Service
public abstract interface BaseService<T>{
    public  T findById(String id);

    public List<T> findAll();

    public void insert(T object);

    public void update(T object);

    public void delete(String id);
}
