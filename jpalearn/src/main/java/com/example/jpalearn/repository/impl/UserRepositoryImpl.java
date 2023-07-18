//package com.example.jpalearn.repository.impl;
//
//
//import com.example.jpalearn.model.User;
//import com.example.jpalearn.repository.IUserRepository;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.util.Assert;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//import java.util.Optional;
//
//
//public class UserRepositoryImpl  extends SimpleJpaRepository<User,Integer> implements IUserRepository {
//
//
//    public UserRepositoryImpl(Class<User> domainClass, EntityManager em) {
//        super(domainClass, em);
//    }
//
////    @Override
////    public void save1(User user) {
////        this.save(user);
////    }
////   public void test1(String name){
////       Query query = this.em.createQuery("select * from User t where t.name = ?1 and t.password = ?2");
////       query.setParameter(1, name);
//////       query.setParameter(2, password);
////       return (User) query.getSingleResult();
////   }
//}
