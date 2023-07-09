package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
//    @Test
//    @SqlSetting(query = "select * from pk_config where step=:step")
//    @FieldMapping({"createtime=create_time"})
//    List<User> getConfig(@Para(value = "aa") int step);
}
