package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping("/Thymeleaf")
@Controller
public class ThymeleafController {

    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            mv.setViewName("redirect:/ThymeleafUser/login");
        } else {
//            mv.setViewName("page/index");
            mv.setViewName("index");
            mv.addObject(user);
        }

        return mv;
    }

    /**
     * http://localhost:8518/api/Thymeleaf/index2
     */
    @RequestMapping(value = "/index2")
    public ModelAndView index2(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("data", "SpringBoot 成功集成 Thymeleaf 模版！");

        User user = new User();
        user.setId(1);
        user.setName("张三");
        mv.addObject("user", user);


        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user1 = new User();
            user1.setId(100 + i);
            user1.setName("张" + i);
            userList.add(user1);
            mv.addObject("userList", userList);

        }


        Map<Integer,Object> userMaps = new HashMap<Integer, Object>();
        for (int i = 0; i < 10; i++) {
            User user1 = new User();
            user1.setId(i);
            user1.setName("张111k" + i);
            userMaps.put(i,user);
        }
        mv.addObject("userMaps",userMaps);


        User[] userArray = new User[10];
        for (int i = 0; i < 10; i++) {
            User user1 = new User();
            user1.setId(i);
            user1.setName("赵六"+i);

            userArray[i] = user;
        }
        mv.addObject("userArray",userArray);


        mv.addObject("sex",1);

        User user1 = null;
        mv.addObject("user1",user1);
        User user2 = new User();
        user2.setId(1001);
        user2.setName("小岳岳");

        mv.addObject("user2",user2);


        User user3 = new User();
        user3.setId(1002);
        user3.setName("孙悦");

        mv.addObject("user3",user3);

        request.getSession().setAttribute("user3",user3);


       mv.addObject("time",new Date());
       mv.addObject("data","SpringBootHelloWorld");

        mv.setViewName("index2");
        return mv;
    }


}
