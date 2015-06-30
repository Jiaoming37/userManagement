package com.tw.core;


import javax.persistence.*;

/**
 * Created by jiaoming on 6/29/15.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private int type;

    @OneToOne
    @JoinColumn(name = "USERID",nullable = false)
    private User user;

    public Employee() {

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
