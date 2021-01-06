package com.inheritance;

import com.config.ORMConfig;
import com.hibernateforeignkeys.beans.*;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InheritanceTest {

    private Session session;

    @Before
    public void openSession(){
        session = ORMConfig.getSessionFactory().openSession();
    }

    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testSingle_Table(){

        Programmer programmer = new Programmer(Programmer.Skills.JAVA, 10000);

        /*programmer.setName("sepehr");
        programmer.setLastName("mollaei");
        programmer.setAge(20);
        programmer.setBonus(10000);
        programmer.setId(98);*/

        Employee employee = new Employee();
        employee.setName("parham");
        employee.setAge(19);
        employee.setId(65);
        employee.setLastName("kabiri");

        session.beginTransaction();
        //session.save(programmer);
        session.save(employee);
        session.getTransaction().commit();

    }

    @Test
    public void testSuperClass(){
        Cat cat = new Cat();
        cat.setColor("black");
        cat.setName("catty");
        cat.setId(12);

        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
    }

    @Test
    public void testJoinedColumn(){
        Computer computer = new Computer();
        computer.setId("1");
        computer.setRam(32);
        computer.setName("hhh");
        computer.setCore("core i7");

        session.beginTransaction();
        session.save(computer);
        session.getTransaction().commit();

    }

    @Test
    public void testAddChildJoinedColumn(){
        ASUSComputer asusComputer = new ASUSComputer();
        asusComputer.setName("mmm");
        asusComputer.setCountry("iran");
        asusComputer.setPrice(10000);
        asusComputer.setCore("core i9");
        asusComputer.setId("91");
        asusComputer.setRam(16);

        session.beginTransaction();
        session.save(asusComputer);
        session.getTransaction().commit();

    }


}
