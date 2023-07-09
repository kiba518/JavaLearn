package com.example.demo.dao.jdbc.impl;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(User user) {
        int update = jdbcTemplate.update("insert into k_user (name,idCard) values (?,?)", user.getName(), user.getIdCard());
        if (update > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from k_user", BeanPropertyRowMapper.newInstance(User.class));
    }


    public boolean update(User user) {

        String updatesql = "update k_user set name=?,idCard=? where id=?";
        Object[] args = {user.getName(), user.getIdCard(), user.getId(),};//注意参数顺序
        int update = jdbcTemplate.update(updatesql, args);
        if (update > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {

        String deletesql = "delete from k_user where id=?";
        int del = jdbcTemplate.update(deletesql, id);
        if (del > 0) {
            return true;
        } else {
            return false;
        }
    }


//
}

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-jdbc</artifactId>
//</dependency>
//<dependency>
//<groupId>mysql</groupId>
//<artifactId>mysql-connector-java</artifactId>
//<version>5.1.47</version>
//</dependency>

//<dependencies>
//<dependency>
//<groupId>mysql</groupId>
//<artifactId>mysql-connector-java</artifactId>
//<version>8.0.26</version>
//<scope>runtime</scope>
//</dependency>
//</dependencies>