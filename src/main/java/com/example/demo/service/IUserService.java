package com.example.demo.service;

import com.example.demo.model.User;

public interface IUserService {
    boolean Insert(User user);
    boolean Update(User user);
    boolean Delete(int id);
    boolean FindAll();
}
