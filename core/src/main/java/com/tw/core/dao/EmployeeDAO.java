package com.tw.core.dao;

import com.tw.core.Employee;
import com.tw.core.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiaoming on 6/29/15.
 */
@Repository
@Transactional
public class EmployeeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> listEmployee() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    public void addEmployee(Employee employee){
        sessionFactory.getCurrentSession().save(employee.getUser());
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee findEmployeeById(long id){
        Employee employee=(Employee)sessionFactory.getCurrentSession().get(Employee.class,id);
        return employee;
    }

    public void updateEmployee(Employee employee)
    {
        sessionFactory.getCurrentSession().update(employee);
    }

    public void deleteEmployee(long id){
        Employee employee=findEmployeeById(id);
        if(employee!=null){
            sessionFactory.getCurrentSession().delete(employee);
        }
    }

    public void deleteEmployeeList(long[] ids){
        for(int index=0;index<ids.length;index++){
            deleteEmployee(ids[index]);
        }
    }

    public List<Employee> listCoach(){
        return sessionFactory.getCurrentSession().createQuery("from Employee where type=1").list();
    }
}
