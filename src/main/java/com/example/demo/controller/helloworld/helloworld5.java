package com.example.demo.controller.helloworld;

import com.example.demo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *RequestParam的使用 不能结合PathVariable使用
 */
@RestController
@RequestMapping("/helloworld5")
public class helloworld5 {

    @PostMapping("/test1")
    public HttpEntity test1(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity(null, HttpStatus.OK);
        } else{
            return new ResponseEntity(user, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 本质上@RequestBody不和get一起使用
     * 请求地址：http://localhost:8518/api/helloworldx/test2
     * {"userId":123,"name":"哈哈哈"}
     * 使用apipost请求
     * @return
     */
    @GetMapping("/test2")
    public HttpEntity test2(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity(new User(123456,"KIBA"), HttpStatus.OK);
        } else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @Validated验证实体注解，需要在实体内添加 @NotEmpty等注解配合
     * BindingResult验证结果
     * @param user
     * @param results
     * @return
     */
    @PostMapping("/test3")
    public String test3(@Validated @RequestBody User user, BindingResult results){
        System.out.println(user);
        if (results.hasErrors()) {
            return "hello false";
        }else {
            return "hello success";
        }
    }
}