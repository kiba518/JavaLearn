package com.example.demo.model;

import com.sun.istack.internal.NotNull;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class User {
    private int id;
    @NotEmpty(message = "姓名不可为空")
    private String name;
    private String idCard;

    /**
     * mybatis和jdbc需要无参构造函数
     */
    public User(){}
    public User(int id, String _name) {
        this.id = id;
        name = _name;
    }
}
