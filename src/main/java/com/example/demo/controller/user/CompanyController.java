package com.example.demo.controller.user;

import com.example.demo.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Company")
public class CompanyController {
    @Autowired
    public ICompanyService companyServiceImpl;
    @Autowired
    public ICompanyService companyService2Impl;

    /**
     * 使用Qualifier指定对应的实现
     */
    @Qualifier("companyServiceImpl")
    @Autowired
    public ICompanyService companyService1;
    @Qualifier("companyService2Impl")
    @Autowired
    public ICompanyService companyService2;

    @GetMapping("/test1")
    public boolean test1() {
        return companyServiceImpl.Insert();
    }

    @GetMapping("/test2")
    public boolean test2() {
        return companyService2Impl.Insert();
    }
}
