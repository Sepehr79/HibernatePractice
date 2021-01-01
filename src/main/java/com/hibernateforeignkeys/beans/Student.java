package com.hibernateforeignkeys.beans;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NamedQueries(
        @NamedQuery(name = "getById", query = "from Student where id = :id")
)
public class Student {
    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private int age;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "uni_name")
    private Uni uni;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "gender")
    private Gender gender;

    @Column
    @CreationTimestamp
    private Date registerDate;

    @Column
    @UpdateTimestamp
    private Date lastUpdateDate;

    public Student(String name, String lastName, int id){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public Student(String name, String lastName, int age, int id, Uni uni, Gender gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.uni = uni;
        this.gender = gender;
    }

    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Uni getUni() {
        return uni;
    }

    public void setUni(Uni uni) {
        this.uni = uni;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", uni=" + uni +
                ", gender=" + gender +
                ", registerDate=" + registerDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
