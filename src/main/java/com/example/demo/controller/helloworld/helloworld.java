package com.example.demo.controller.helloworld;

import com.example.demo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {
    /**
     * http://localhost:8518/api/helloworld/Test1?id=1
     * @param id
     * @return
     */
    @GetMapping(value = "/helloworld/Test1")
    public String Test1(Integer id) {
        return "user";
    }

    /**
     * http://localhost:8518/api/helloworld/Test2?id=1
     * @param id
     * @return
     */
    @GetMapping(value = "/helloworld/Test2")
    public String Test2(String id) {
        return "user";
    }

    /**
     * http://localhost:8518/api/helloworld2/Test3?boo=true
     * @param boo
     * @return
     */
    @RequestMapping(value = "/helloworld/Test3")
    public String Test3(Boolean boo) {
        return "user";
    }

}
