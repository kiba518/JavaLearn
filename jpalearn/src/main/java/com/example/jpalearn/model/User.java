package com.example.jpalearn.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="k_user")
@Data
public class User {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "idcard")
    private String idcard;

    /**
     * mybatis和jdbc需要无参构造函数
     */
    public User(){}
    public User(int id, String _name) {
        this.id = id;
        name = _name;
    }
}