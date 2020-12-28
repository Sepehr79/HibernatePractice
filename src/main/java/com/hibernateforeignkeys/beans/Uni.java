package com.hibernateforeignkeys.beans;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Uni {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NaturalId(mutable = true) // we cant change it
    private String name;

    @Column
    private String city;

    @OneToMany(mappedBy = "uni", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;

    public Uni(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public Uni() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
