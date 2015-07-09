package com.tw.core;

import com.tw.core.dao.CourseDAO;
import com.tw.core.dao.CustomerDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jiaoming on 7/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
@Transactional
public class CourseDAOTest {

    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private CustomerDAO customerDAO;

    @Test
    public void test_find_course_by_course_name_method(){
        String course_name="high";
        Course course=courseDAO.findByCourseName(course_name);
        System.out.println(course.getName()+","+course.getId());
    }

    @Test
    public void test_add_course_to_customer(){
        String course_name="high";
        Course course=courseDAO.findByCourseName(course_name);
        Customer customer=customerDAO.findCustomerById(7);
        customer.getCourses().add(course);
        System.out.println(customer.getCourses().isEmpty());
    }
}
