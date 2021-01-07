package com.jpa;

import com.hibernateforeignkeys.jpabeans.Phone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PracticeJPA {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    @Before
    public void openEntityManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Fod");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void closeEntityManager(){
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void insertPhone(){
        Phone phone = new Phone();
        phone.setId(10);
        phone.setName("A40");
        entityManager.getTransaction().begin();
        entityManager.persist(phone);
        entityManager.getTransaction().commit();
    }

    @Test
    public void deleteAndFindPhone(){
        Phone phone = entityManager.find(Phone.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(phone);
        entityManager.getTransaction().commit();

    }

    @Test
    public void updatePhone(){
        Phone phone = entityManager.find(Phone.class, 5);

        System.out.println(phone.getName());

        entityManager.getTransaction().begin();
        phone.setName("A10");
        entityManager.getTransaction().commit();

        System.out.println(phone.getName());

    }

}
