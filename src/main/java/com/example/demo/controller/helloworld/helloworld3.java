package com.example.demo.controller.helloworld;

import com.example.demo.model.User;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *PathVariable的使用
 */
@RestController
@RequestMapping("/helloworld3")
public class helloworld3 {

    /**
     * 请求地址：http://localhost:8518/api/helloworld3/test1/1/user
     * 会将地址中test1后面的参数，分别交给{}里配置的参数
     * @PathVariable("id")中的参数，是指定外发的参数名，可以不等于实际参数
     * @param idLong
     * @param nameStr
     * @return
     */
    @GetMapping("/test1/{id}/{name}")
    public String test1(@PathVariable("id") Long idLong, @PathVariable("name") String nameStr) {
        return "user";
    }
    /**
     * 请求地址：http://localhost:8518/api/helloworld3/test2/1/user
     * 未使用@PathVariable("id")模式，因此使用参数本身的名字去匹配地址参数
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/test2/{id}/{name}")
    public String test2(@PathVariable Long id, @PathVariable String name) {
        return "user";
    }

    /**
     * 与RequestMapping一起使用
     * 请求地址：http://localhost:8518/api/helloworld3/test3/user
     * @param name
     * @return
     */
    @RequestMapping("/test3/{name}")
    public String test3(@PathVariable("name") String name){
        return "user";
    }

}