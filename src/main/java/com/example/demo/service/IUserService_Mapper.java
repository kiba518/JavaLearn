package com.example.demo.service;

import com.example.demo.model.User;

public interface IUserService_Mapper {

    boolean Insert(User user);
    boolean Update(User user);
    boolean Delete(int id);
    boolean FindAll();
}
