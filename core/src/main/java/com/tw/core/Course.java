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

    @ManyToOne
    @JoinColumn(name="COACH_ID",nullable = false)
    private Employee coach;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="CUSTOMER_COURSE_JOIN",
            joinColumns = {@JoinColumn(name="COURSE_ID")},
            inverseJoinColumns = {@JoinColumn(name="CUSTOMER_ID")}
    )
    private Set<Customer> customers;

    @OneToMany(mappedBy = "course",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<CourseTime> courseTimes;

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

    public Set<CourseTime> getCourseTimes() {
        return courseTimes;
    }

    public void setCourseTimes(Set<CourseTime> courseTimes) {
        this.courseTimes = courseTimes;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Employee getCoach() {
        return coach;
    }

    public void setCoach(Employee coach) {
        this.coach = coach;
    }
}
