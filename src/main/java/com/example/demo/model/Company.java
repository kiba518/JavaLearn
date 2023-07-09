package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Company {
    public int id;
    @NotEmpty(message = "公司名不可为空")
    public String Name;

    public Company(int id, String name) {
        this.id = id;
        Name = name;
    }
}
