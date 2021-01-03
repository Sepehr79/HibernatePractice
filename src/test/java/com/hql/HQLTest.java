package com.hql;

import com.hibernateforeignkeys.beans.Student;
import com.config.ORMConfig;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class HQLTest {

    private static Session session;

    @Before
    public void openSession(){
        session = ORMConfig.getSessionFactory().openSession();
    }

    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testGetList(){
        List<Student> studentList = session.createQuery("from Student").list();
        Student student = studentList.get(0);
        Assert.assertEquals(student.getName(), "sepehr");
        Assert.assertEquals(student.getLastName(), "ahmadi");
    }

    @Test
    public void testGetWithWhere(){
        Iterator iterate = session.createQuery("from Uni where city = 'isfahan'").iterate();
        System.out.println(iterate.hasNext());
    }

    @Test
    public void getWithConstructor(){
        Student student = getStudentById(36);

        System.out.println(student);
    }

    public static Student getStudentById(int id){
        Student student = (Student) session.createQuery("select new Student(s.name, s.lastName, s.id) from Student s where id = :id").
                setParameter("id", id).uniqueResult();

        return student;
    }

    @Test
    public void testNamedQueries(){
        Student student =(Student) session.createNamedQuery("getById").setParameter("id", 36).uniqueResult();
        Assert.assertEquals(student.getName(), "sepehr");
    }

}
