package com.tw.core;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jiaoming on 6/30/15.
 */
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name="COACH_ID")
    private int coach_id;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="CUSTOMER_COURSE_JOIN",
            joinColumns = {@JoinColumn(name="COURSE_ID")},
            inverseJoinColumns = {@JoinColumn(name="CUSTOMER_ID")}
    )
    private Set<Customer> customers;

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoach_id(){return coach_id;}

    public void setCoach_id(int coach_id){ this.coach_id=coach_id;}

    public Set<Customer> getCustomers(){return customers;}

    public void setCustomers(Set<Customer> customers){this.customers=customers;}

}
