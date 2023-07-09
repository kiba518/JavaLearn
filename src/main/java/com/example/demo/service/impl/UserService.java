package com.example.demo.service.impl;

import com.example.demo.dao.jdbc.impl.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    public UserDao userDao;

    @Override
    public boolean Insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean Update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean Delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public boolean FindAll() {
        List<User> list = userDao.findAll();
        return true;
    }


}
