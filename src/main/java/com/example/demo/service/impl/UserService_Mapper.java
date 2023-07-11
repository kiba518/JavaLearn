package com.example.demo.service.impl;


import com.example.demo.model.User;
import com.example.demo.service.IUserService_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService_Mapper implements IUserService_Mapper {

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public boolean Insert(User user) {
        //int insert = userMapper.insert(user);
        return true;
    }

    @Override
    public boolean Update(User user) {
        //int update =  userMapper.updateById(user);
        return true;
    }

    @Override
    public boolean Delete(int id) {
        //int delete =  userMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean FindAll() {
        //List<User> list = userMapper.findAll();
        return true;
    }
}
