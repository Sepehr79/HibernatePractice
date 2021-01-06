package com.hibernateforeignkeys.beans;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Computer {

    public String id;
    public String core;
    public int ram;
    public String name;


    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    @Column
    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    @Column
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
