package com.example.demo.controller.user;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    public IUserService userService;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @PostMapping("/Insert")
    public boolean Insert(@RequestBody User user) {
        return  userService.Insert(user);
    }

    @PostMapping("/Update")
    public boolean Update(@RequestBody User user) {
        return  userService.Update(user);
    }

    @GetMapping("/Delete")
    public boolean Delete(int id) {
        return  userService.Delete(id);
    }


    @GetMapping("/test1")
    public boolean test1() {
       return  userService.FindAll();
    }


}
