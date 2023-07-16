package com.example.demo.model;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@TableName("k_user")
@Data
public class User {
    private int id;
    private String name;
    @TableField("idCard")
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