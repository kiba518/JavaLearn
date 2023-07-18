package com.example.jpalearn.service;

import com.example.jpalearn.model.User;
import com.example.jpalearn.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserServiceImpl {
    public void create() {
        //获取管理对象工厂
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactoryInstance();
        //得到管理对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //得到事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User();
        user.setName("Jay");
        user.setIdcard("123456");

        entityManager.persist(user);
        //每次得新建一个对象
        user = new User();
        user.setName("Jay1");
        user.setIdcard("1234561");
        entityManager.persist(user);
        //提交事务
        transaction.commit();
        //关闭管理对象
        entityManager.close();
        entityManagerFactory.close();
    }

    public void baseTest1() throws Exception {
        //获取管理对象工厂
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactoryInstance();
        //得到管理对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //1、JPQL 查询
        entityManager.createQuery("JPQL");
        TypedQuery<User> jpql = entityManager.createQuery("JPQL", User.class);

        //设置参数
        jpql.setParameter(1,"索引参数 ?1");
        jpql.setParameter("name","命名参数");

        //分页查询
        jpql.setFirstResult(10);
        jpql.setMaxResults(20);

        //查询返回结果
        User singleResult = jpql.getSingleResult();
        List<User> resultList = jpql.getResultList();

        //用于Update 或 delete 操作
        int i = jpql.executeUpdate();

        //2、传统SQL查询方式
        entityManager.createNativeQuery("SQL");
        entityManager.createNativeQuery("SQL",User.class);

        //3、命名查询
        entityManager.createNamedQuery("queryName");
        entityManager.createNamedQuery("queryName",User.class);

        entityManager.close();
    }

    public void findOne() {
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactoryInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //查询可以不用事务  提高效率
        User employee1 = entityManager.find(User.class, 1L);// private Long id; 主键严格按照类型处理
        System.out.println("SELECT:" + employee1.toString());
        entityManager.close();
        //关闭管理对象工厂实例
        entityManagerFactory.close();
    }

    //User login(String name, String password);
//    public User login(String name, String password) {
//        return userDao.login(name, password);
//    }
}
