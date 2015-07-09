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

    @ManyToOne
    @JoinColumn(name="PRIVATE_COACH",nullable = true)
    private Employee privateCoach;

    @ManyToMany(mappedBy = "customers",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
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

    public Set<Course> getCourses(){return courses;}

    public void setCourses(Set<Course> courses){this.courses=courses;}

    public Employee getPrivateCoach() {
        return privateCoach;
    }

    public void setPrivateCoach(Employee privateCoach) {
        this.privateCoach = privateCoach;
    }
}
