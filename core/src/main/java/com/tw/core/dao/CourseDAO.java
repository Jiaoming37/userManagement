package com.tw.core.dao;

import com.tw.core.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiaoming on 6/30/15.
 */
@Repository
@Transactional(readOnly = true)
public class CourseDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CourseDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public List<Course> listCourse(){
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }

    public void addCourse(Course course){
        sessionFactory.getCurrentSession().save(course);
    }

    public Course findCourseById(long id){
        Course course=(Course)sessionFactory.getCurrentSession().get(Course.class,id);
        return course;
    }

    public void updateCourse(Course course){
        sessionFactory.getCurrentSession().update(course);
    }

    public void deleteCourse(long id){
        Course course=findCourseById(id);
        if(course!=null){
            sessionFactory.getCurrentSession().delete(course);
        }
    }

}
