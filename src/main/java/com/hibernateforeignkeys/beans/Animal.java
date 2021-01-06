package com.hibernateforeignkeys.beans;

import javax.persistence.*;

@MappedSuperclass
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column
    public String name;

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
}
