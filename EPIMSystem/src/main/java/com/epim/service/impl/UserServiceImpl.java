package com.epim.service.impl;

import com.epim.entity.User;
import com.epim.mapper.UserMapper;
import com.epim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User findById(String id) {
        return this.userMapper.findById(id);
    }

    public List<User> findAll() {
        return null;
    }

    public void insert(User object) {
        this.userMapper.insert(object);
    }

    public void update(User object) {
        this.userMapper.update(object);
    }

    public void delete(String id) {
        this.userMapper.deleteById(id);
    }
}
