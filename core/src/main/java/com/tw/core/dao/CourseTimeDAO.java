package com.tw.core.dao;

import com.tw.core.CourseTime;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiaoming on 7/1/15.
 */
@Repository
@Transactional(readOnly = false)
public class CourseTimeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CourseTimeDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public List<CourseTime> courseTimeList(){
        return sessionFactory.getCurrentSession().createQuery("from CourseTime").list();
    }

    public void addCourseTime(CourseTime courseTime){
        sessionFactory.getCurrentSession().save(courseTime);
    }

    public CourseTime findCourseTimeById(long id){
        CourseTime courseTime=(CourseTime)sessionFactory.getCurrentSession().get(CourseTime.class,id);
        return courseTime;
    }

    public void updateCourseTime(CourseTime courseTime){
        sessionFactory.getCurrentSession().update(courseTime);
    }

    public void deleteCourseTime(long id){
        CourseTime courseTime=findCourseTimeById(id);
        if(courseTime!=null){
            sessionFactory.getCurrentSession().delete(courseTime);
        }
    }
}
