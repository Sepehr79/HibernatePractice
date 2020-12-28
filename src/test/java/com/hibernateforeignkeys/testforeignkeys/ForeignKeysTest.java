package com.hibernateforeignkeys.testforeignkeys;

import com.hibernateforeignkeys.beans.*;
import com.hibernateforeignkeys.config.ORMConfig;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ForeignKeysTest {

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
    public void addStudent(){
        try{
            session.beginTransaction();

            Uni uni = session.find(Uni.class, 1);
            Gender gender = session.find(Gender.class, 1);
            Student student = new Student("mojtaba", "ahmadi", 20, 36, uni, gender);
            session.save(student);



            session.getTransaction().commit();
        }catch (Exception exception){
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testGetStudentGenderUni(){
        Student student = session.find(Student.class, 36);
        System.out.println(student);
        Assert.assertEquals(student.getUni().getName(), "tehran");
    }

    @Test
    public void getStudentsByGender(){
        List<Student> students = session.find(Gender.class, 1).getStudents();
        Assert.assertEquals(students.size(), 1);
        Assert.assertEquals(students.get(0).getName(), "sepehr");
    }

    @Test
    public void addTeacher(){
        session.beginTransaction();
        Teacher teacher = new Teacher();
        teacher.setName("hosein");
        teacher.setId(6);
        session.save(teacher);
        session.getTransaction().commit();
    }

    @Test
    public void addCourse(){
        try(Session session = ORMConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Courese courese = new Courese();
            courese.setName("chemistry");
            courese.setId(2);
            courese.setDifficulty(Courese.Difficulty.MEDIUM);
            session.save(courese);
            session.getTransaction().commit();
        }
    }
    @Test
    public void addCourseToTeacher(){
        try(Session session = ORMConfig.getSessionFactory().openSession()) {
            session.beginTransaction();

            Courese courese = session.find(Courese.class, 1);
            Teacher teacher = session.find(Teacher.class, 1);
            teacher.getCourseList().add(courese);
            session.update(teacher);
            session.getTransaction().commit();
        }
    }

    @Test
    public void getTeacherFromCourse(){

        try(Session session = ORMConfig.getSessionFactory().openSession()) {
            Courese courese = session.find(Courese.class, 1);
            Teacher teacher = courese.getTeacherList().get(0);
            Assert.assertEquals(teacher.getName(), "ahmad");
        }

    }

    @Test
    public void addUni(){
        try(Session session = ORMConfig.getSessionFactory().openSession()){
            session.beginTransaction();

            Uni uni = new Uni();
            uni.setName("isfahan");
            uni.setCity("isfahan");
            session.save(uni);
            session.getTransaction().commit();
        }
    }

    @Test
    public void updateStudent(){
        try(Session session = ORMConfig.getSessionFactory().openSession()){
            session.beginTransaction();

            Student student = session.find(Student.class, 36);
            student.setName("sepehr");
            session.update(student);

            session.getTransaction().commit();
        }
    }

    @Test
    public void getStudent(){

        Student student = null;
        try(Session session = ORMConfig.getSessionFactory().openSession()){
            student = session.get(Student.class, 36);
        }

        try(Session session = ORMConfig.getSessionFactory().openSession()){
            session.refresh(student);
        }


    }

    @Test
    public void testGetNaturalId(){
        try(Session session = ORMConfig.getSessionFactory().openSession()) {
            Uni uni = (Uni) session.bySimpleNaturalId(Uni.class).load("tehran");
            Assert.assertEquals(uni.getName(), "tehran");

            uni.setName("tehran");
            session.beginTransaction();
            session.update(uni);
            session.getTransaction().commit();
        }
    }

    @Test
    public void testHQL(){
        List people = session.createQuery("from Person").list();
        Assert.assertEquals(people.size(), 0);
    }
}
