package com.epim.service;

import java.util.List;

public abstract interface Service<T>{
    public  T findById(String id);

    public List<T> findAll();

    public void insert(T object);

    public void update(String id,T object);

    public void deleteById(String id);
}
