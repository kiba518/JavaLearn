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
        return userService_mapper.Insert(user);
    }

    @PostMapping("/Update")
    public boolean Update(@RequestBody User user) {
        return userService_mapper.Update(user);
    }

    @GetMapping("/Delete")
    public boolean Delete(int id) {
        return userService_mapper.Delete(id);
    }


    @GetMapping("/test1")
    public boolean test1() {
        return userService_mapper.FindAll();
    }

    @GetMapping("/test2")
    public boolean test2() {
        return userService_mapper.test2();
    }

    @GetMapping("/test3")
    public boolean test3() {
        return userService_mapper.test3();
    }

    @GetMapping("/test4")
    public boolean test4() {
        return userService_mapper.test4();
    }

    @GetMapping("/test5")
    public boolean test5() {
        return userService_mapper.test5();
    }

    @GetMapping("/test6")
    public boolean test6() {
        return userService_mapper.test6();
    }

    @GetMapping("/test7")
    public boolean test7() {
        return userService_mapper.test7();
    }

    @GetMapping("/test8")
    public boolean test8() {
        return userService_mapper.test8();
    }
}