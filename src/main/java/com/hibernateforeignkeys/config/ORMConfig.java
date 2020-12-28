package com.hibernateforeignkeys.config;

import com.hibernateforeignkeys.beans.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ORMConfig {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Uni.class).
                addAnnotatedClass(Gender.class).
                addAnnotatedClass(Person.class).
                addAnnotatedClass(Teacher.class).
                addAnnotatedClass(Courese.class).
                addAnnotatedClass(FingerPrint.class).
                buildSessionFactory();
    }

    private ORMConfig(){

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        ORMConfig.sessionFactory = sessionFactory;
    }
}
