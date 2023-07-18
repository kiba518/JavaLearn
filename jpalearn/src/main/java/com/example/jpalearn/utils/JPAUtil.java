package com.example.jpalearn.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactoryInstance() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("com.zqj.jpa");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entityManagerFactory;
    }
}