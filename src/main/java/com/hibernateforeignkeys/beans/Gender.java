package com.hibernateforeignkeys.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Gender {
    @Id
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
