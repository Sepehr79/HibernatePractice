package com.hibernateforeignkeys.beans;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Person {
    @Id
    private int id;

    @Column
    private int age;

    @Column
    private String name;

    @OneToOne
    private FingerPrint fingerPrint;

    public FingerPrint getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(FingerPrint fingerPrint) {
        this.fingerPrint = fingerPrint;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
