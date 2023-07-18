package com.example.jpalearn.repository;

import com.example.jpalearn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {
    /**
     * #常规查询
     * 根据属性名称来定义查询方法
     * @param name
     * @return
     */
    List<User> findByName(String name);
    /**
     * #限制结果查询
     * 结果数量是使用 top和first 扥关键字来实现的
     * @param name
     * @return
     */
    List<User> findFirst10ByName(String name);

    @Query(value="select * from k_user where  idCard = ?1 and name =?2",nativeQuery = true)
    List<User> findByidCard(String idCard,String name);

    //    @Query(value="select * from cst_customer where cust_name=?1",nativeQuery = true)
//    @Query(value="from Customer  where cust_name= ?1")
//    @Query(value="select c from Customer  c where c.custName=?1")
//    @Query(value="from Customer c where c.custName=:#{#custName}")
//    @Query(value="from Customer c where c.custName=:custName")
//    List<Customer> findAllCustomerByName(@Param("custName") String custName);

}
