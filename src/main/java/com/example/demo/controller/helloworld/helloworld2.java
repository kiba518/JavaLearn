package com.example.demo.controller.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *RequestMapping结合GetMapping使用
 */
@RestController
@RequestMapping("/helloworld2")
public class helloworld2 {

    @GetMapping(value = "/Test1")
    public String Test1(Integer id) {
        return "user";
    }
    @GetMapping(value = "/Test2")
    public String Test2(String id) {
        return "user";
    }
}
