package com.criteria;

import com.config.ORMConfig;
import com.hibernateforeignkeys.beans.Person;
import com.hibernateforeignkeys.beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PracticeCriteria {

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
    public void testCriteria(){
        Student student =(Student) session.createCriteria(Student.class).add(Restrictions.eq("id", 36)).uniqueResult();
        System.out.println(student);
    }

    @Test
    public void getPersonsCriteria(){
        List<Person> people = session.createCriteria(Person.class, "pr").setMaxResults(50).list();
    }

    @Test
    public void testRestrictions(){
        Student student = (Student) session.createCriteria(Student.class).add(Restrictions.eq("name", "sepehr"))
                .add(Restrictions.eq("lastName", "ahmadi")).uniqueResult();

        System.out.println(student);
    }

    @Test
    public void testConjunction(){
        /**
         * Conjunction is for and operator
         */
        List<Student> students = session.createCriteria(Student.class).add(Restrictions.conjunction(
                Restrictions.gt("id", 100), Restrictions.eq("lastName", "ahmadi")
        )).list();

        for (Student student:
             students) {
            System.out.println(student);
        }
    }

    @Test
    public void testDisjunction(){
        /**
         * Disjunction is or operator
         */
        List<Student> students = session.createCriteria(Student.class).add(Restrictions.disjunction(
                Restrictions.gt("id", 100), Restrictions.eq("lastName", "ahmadi")
        )).list();

        for (Student student:
                students) {
            System.out.println(student);
        }
    }

    @Test
    public void testProperty(){
        Property id = Property.forName("id");

        Student student = (Student) session.createCriteria(Student.class).add(id.eq(36)).uniqueResult();
        System.out.println(student);
    }

    @Test
    public void testOrder(){
        List<Student> students = session.createCriteria(Student.class).addOrder(Order.asc("id")).list();

        for (Student student: students){
            System.out.println(student);
        }
    }

    /*
    @Test
    public void testAlias(){
        List list = session.createCriteria(Student.class).createAlias("Gender", "ge").add(Restrictions
                .eqProperty("ge.name", "MALE")).list();

        for (Object o:
             list) {
            System.out.println(o);
        }

    }
    */

    @Test
    public void testResultTransformer(){
        session.createCriteria(Student.class).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
    }

    @Test
    public void testExample(){
        Student student = new Student(null, null, 36);
        List<Student> result = session.createCriteria(Student.class).add(Example.create(student)).list();

        for (Student student1: result)
            System.out.println(student1);
    }

    @Test
    public void testProjection(){
        List list = session.createCriteria(Student.class).setProjection(Projections.projectionList().add(Projections.property("name")).add(Projections.property("lastName"))).list();
        Object[] objects = (Object[]) list.get(0);
        System.out.println(objects.length);
        System.out.println(objects[0]);
    }

    @Test
    public void testDetachedCriteria(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Student.class).setProjection(Property.forName("age").avg());

        List<Student> students = session.createCriteria(Student.class).add(Property.forName("age").gt(criteria)).addOrder(Order.asc("age")).list();
        System.out.println(students);
    }




}
