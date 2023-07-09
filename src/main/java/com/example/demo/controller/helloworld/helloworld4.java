package com.example.demo.controller.helloworld;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *RequestParam的使用 不能结合PathVariable使用
 */
@RestController
@RequestMapping("/helloworld4")
public class helloworld4 {

    /**
     *  http://localhost:8518/api/helloworld4/test1?userName=abc
     *  注意test1小写t
     * @param name
     * @return
     */
    @GetMapping("/test1")
    public String test1(@RequestParam(value="userName") String name) {
        return "user";
    }


    /**
     *  http://localhost:8518/api/helloworld4/test2?userName=abc
     *  http://localhost:8518/api/helloworld4/test2
     * required = false 允许userName参数不传递
     * @param name
     * @return
     */
    @GetMapping("/test2")
    public String test2(@RequestParam(value="userName",required = false) String name) {
        return "user";
    }


}