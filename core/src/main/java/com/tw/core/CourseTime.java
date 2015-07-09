package com.tw.core;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by jiaoming on 7/1/15.
 */
@Entity
@Table(name="COURSE_TIME")
public class CourseTime {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="COURSE_ID")
    private Course course;

    @Column(name="TIME")
    private Date time;

    public CourseTime() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
