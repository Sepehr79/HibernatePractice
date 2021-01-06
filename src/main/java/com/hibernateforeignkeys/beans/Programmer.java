package com.hibernateforeignkeys.beans;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PRM")
public class Programmer extends Employee{

    @Column
    @Enumerated(EnumType.STRING)
    private Skills skills;

    @Column
    private int bonus;

    public Programmer(){

    }

    public Programmer(Skills skills, int bonus) {
        this.skills = skills;
        this.bonus = bonus;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public static enum Skills{
        JAVA, CSHARP,CPP, C, PYTHON, RUBY, JS
    }
}
