package com.tw.core.service;

import com.tw.core.CourseTime;
import com.tw.core.dao.CourseTimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiaoming on 7/1/15.
 */
@Service
public class CourseTimeService {
    private CourseTimeDAO courseTimeDAO;

    @Autowired
    public CourseTimeService(CourseTimeDAO courseTimeDAO){
        this.courseTimeDAO=courseTimeDAO;
    }

    public List<CourseTime> listCourseTime(){
        return courseTimeDAO.courseTimeList();
    }

    public void addCourseTime(CourseTime courseTime){
        courseTimeDAO.addCourseTime(courseTime);
    }

    public CourseTime findCourseTimeById(long id){
        return courseTimeDAO.findCourseTimeById(id);
    }

    public void updateCourseTime(CourseTime courseTime){
        courseTimeDAO.updateCourseTime(courseTime);
    }

    public void deleteCourseTime(long id){
        courseTimeDAO.deleteCourseTime(id);
    }
}
