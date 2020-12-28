package com.hibernateforeignkeys.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Teacher {

    @Id
    private int id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "teacher_course",joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "courese_id"))
    private List<Courese> courseList;

    public Teacher() {
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

    public List<Courese> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Courese> courseList) {
        this.courseList = courseList;
    }
}
