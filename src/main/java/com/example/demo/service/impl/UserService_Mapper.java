package com.example.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.IUserService_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService_Mapper implements IUserService_Mapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean Insert(User user) {
        int insert = userMapper.insert(user);
        return true;
    }

    @Override
    public boolean Update(User user) {
        int update =  userMapper.updateById(user);
        return true;
    }

    @Override
    public boolean Delete(int id) {
        int delete =  userMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean FindAll() {
        List<User> list = userMapper.findAll();
        return true;
    }

    @Override
    public boolean test() {
        List<User> list = userMapper.test();
        return false;
    }

    @Override
    public boolean test2() {
        List<User> list = userMapper.test2(1);
        return false;
    }

    @Override
    public boolean test3() {
        List<User> list = userMapper.test3(1);
        return false;
    }

    @Override
    public boolean test4() {
        List<User> list = userMapper.test4("1");
        return false;
    }

    @Override
    public boolean test5() {
        List<User> list = userMapper.test5(1,"zhang");
        return false;
    }

    @Override
    public boolean test6() {
        List<User> list = userMapper.test6(1,"zhang");
        return false;
    }
    @Override
    public boolean test7() {
        Page<User> page = new Page<>(1, 10);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        //IPage<User> orderPage1 = userMapper.selectPage(page, wrapper);
        IPage<User> orderPage = userMapper.selectPage(page, null);
        List<User> orders = orderPage.getRecords();
        long total = orderPage.getTotal();
        return false;
    }

    @Override
    public boolean test8() {
        Page<User> page = new Page<>(1, 1);
        List<User> orderPage = userMapper.queryPageList(page,"1");
//        List<User> orders = orderPage.getRecords();
//        long total = orderPage.getTotal();
        return false;
    }



}
