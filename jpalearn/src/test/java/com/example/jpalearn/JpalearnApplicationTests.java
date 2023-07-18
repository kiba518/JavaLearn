package com.example.jpalearn;

import com.example.jpalearn.model.User;
import com.example.jpalearn.repository.IUserRepository;
import com.example.jpalearn.utils.JPAUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.ExampleMatcher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@SpringBootTest
class JpalearnApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private IUserRepository userRepository;

    @Test
    public void baseTest() throws Exception {
        User user = new User();
        user.setName("Jay11");
        user.setIdcard("12345611");
        userRepository.save(user);
//        userRepository.delete(user);
//        userRepository.findOne(1);
    }
    @Test
    public void findAll() {
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactoryInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //如果出现jpql出现的sql关键字 大小写不敏感
        //最标准的写法
//        String jpql = "SELECT o " +
//                     " FROM com.zqj.crud.Employee o";//不能出现表明列名,以及*号 只能是JAVA的类名，属性名，别名
        //推荐写法
        String jpql = "SELECT o " +
                " FROM User o";//不能出现表明列名,以及*号 只能是JAVA的类名，属性名，别名

        Query query = entityManager.createQuery(jpql);
        List<User> resultList = query.getResultList();
        for (User e : resultList) {
            System.out.println(e.toString());
        }
        entityManager.close();
        //关闭管理对象工厂实例
        entityManagerFactory.close();
    }

}
