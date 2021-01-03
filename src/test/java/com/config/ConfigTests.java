package com.config;

import org.hibernate.Session;
import org.junit.Test;

public class ConfigTests {

    @Test
    public void testBuildSession(){
        Session session = ORMConfig.getSessionFactory().openSession();
    }

}
