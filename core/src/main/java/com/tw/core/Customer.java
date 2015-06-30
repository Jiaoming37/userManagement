package com.tw.core;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jiaoming on 6/30/15.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name="PRIVATE_COACH",nullable = true)
    private int private_coach;

    @ManyToMany(mappedBy = "customers",fetch=FetchType.EAGER)
    //@JoinTable(name="CUSTOMER_COURSE_JOIN",
    //        joinColumns = {@JoinColumn(name="CUSTOMER_ID")},
    //        inverseJoinColumns = {@JoinColumn(name="COURSE_ID")}
    //)
    private Set<Course> courses;

    public Customer() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrivate_coach(){return private_coach;}

    public void setPrivate_coach(int private_coach){ this.private_coach=private_coach;}

    public Set<Course> getCourses(){return courses;}

    public void setCourses(Set<Course> courses){this.courses=courses;}

    }
