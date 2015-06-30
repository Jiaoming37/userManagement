package com.tw.core.service;

import com.tw.core.Course;
import com.tw.core.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiaoming on 6/30/15.
 */
@Service
public class CourseService {
    private CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO){
        this.courseDAO=courseDAO;
    }

    @Transactional
    public List<Course> listCourse(){
        return courseDAO.listCourse();
    }

    @Transactional
    public void addCourse(Course course){
        courseDAO.addCourse(course);
    }

    @Transactional
    public Course findCustomerById(long id){
        return courseDAO.findCourseById(id);
    }

    @Transactional
    public void updateCourse(Course course){
        courseDAO.updateCourse(course);
    }

    @Transactional
    public void deleteCourse(long id){
        courseDAO.deleteCourse(id);
    }
}
