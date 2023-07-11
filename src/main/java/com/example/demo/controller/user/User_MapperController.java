package com.example.demo.controller.user;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.IUserService_Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User_Mapper")
public class User_MapperController {
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    public IUserService_Mapper userService_mapper;


    @PostMapping("/Insert")
    public boolean Insert(@RequestBody User user) {
        return  userService_mapper.Insert(user);
    }

    @PostMapping("/Update")
    public boolean Update(@RequestBody User user) {
        return  userService_mapper.Update(user);
    }

    @GetMapping("/Delete")
    public boolean Delete(int id) {
        return  userService_mapper.Delete(id);
    }


    @GetMapping("/test1")
    public boolean test1() {
       return  userService_mapper.FindAll();
    }


}
