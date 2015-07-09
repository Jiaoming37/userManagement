package com.tw.core;

import com.tw.core.dao.EmployeeDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiaoming on 7/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
@Transactional
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;


    @Test
    public void employee_list_is_corrects() {

        List<Employee> employees = employeeDAO.listEmployee();
        System.out.println("-------------------");
        System.out.println(employees);
        System.out.println("-------------------");

    }

    @Test
    public void test_employee_add_if_use_add_with_cascade(){
        Employee employee=new Employee();
        employee.setName("aa");
        employee.setType(1);
        User user=new User();
        user.setName("lilei");
        user.setPassword("lili");
        user.setEmail("lilei@abc.com");
        user.setAge(23);
        employee.setUser(user);
        employeeDAO.addEmployee(employee);
        List<Employee> list=employeeDAO.listCoach();
        System.out.println(list);
    }
}
