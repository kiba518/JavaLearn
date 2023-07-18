package com.example.jpalearn.controller;

import com.example.jpalearn.model.User;
import com.example.jpalearn.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Hello")
public class Hello {
    @Autowired
    IUserRepository iUserRepository;

    @GetMapping("test")
    public List<User> test() {
        List<User> list = iUserRepository.findAll();

        User user = new User();
        user.setName("Jay11");
        user.setIdcard("12345611");
        iUserRepository.save(user);
        List<User>  list1 = iUserRepository.findByName("Jay11");
        List<User>  list2 = iUserRepository.findByidCard("121","等等");
        return list;
    }
}
//https://blog.csdn.net/qq_44766883/article/details/107011045

//单参数查询
////    @Query(value="select * from cst_customer where cust_name=?1",nativeQuery = true)
////    @Query(value="from Customer  where cust_name= ?1")
////    @Query(value="select c from Customer  c where c.custName=?1")
////    @Query(value="from Customer c where c.custName=:#{#custName}")
//@Query(value="from Customer c where c.custName=:custName")
//    List<Customer> findAllCustomerByName(@Param("custName") String custName);
//        1
//        2
//        3
//        4
//        5
//        6
//        这几种方式是等价的
//
//@Query(value=“select * from cst_customer where cust_name=?1”,nativeQuery = true)
//@Query(value=“from Customer where cust_name= ?1”)
//@Query(value=“select c from Customer c where c.custName=?1”)
//@Query(value=“from Customer c where c.custName=:#{#custName}”)
//@Query(value=“from Customer c where c.custName=:custName”)
//
//
//
//多参数查询
////    @Query(value="from Customer  c where c.custId=?2 and c.custName=?1")
////    @Query(value="from Customer  c where c.custId=:#{#custId} and c.custName=:#{#custName}")
//@Query(value="from Customer  c where c.custId=:custId and c.custName=:custName")
//List<Customer> findCustomersByNameAndIndus(@Param("custName") String name,@Param("custId") Long id);
//        1
//        2
//        3
//        4
//        这几种方式是等价的(还有一种原生sql的方式)
//
//@Query(value=“from Customer c where c.custId=?2 and c.custName=?1”)
//@Query(value=“from Customer c where c.custId=:#{#custId} and c.custName=:#{#custName}”)
//@Query(value=“from Customer c where c.custId=:custId and c.custName=:custName”)
//
//
//
//参数为对象查询
//@Query(value="from Customer  c where c.custId=:#{#customer.custId}")
//Customer findCustomerByInfo(@Param("customer") Customer customer);
//