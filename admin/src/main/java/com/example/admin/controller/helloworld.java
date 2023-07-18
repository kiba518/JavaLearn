package com.example.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloworld")
public class helloworld {
    @PostMapping("test")
    public String test() {
        return "这是 test";
    }
    @GetMapping("/index")
    public String index() {
        return "这是 index";
    }

}
