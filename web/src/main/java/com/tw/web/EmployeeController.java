package com.tw.web;

import com.tw.core.Employee;
import com.tw.core.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by jiaoming on 6/29/15.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @RequestMapping("/all")
    public List<Employee> listEmployee(){
        return employeeService.listEmployee();
    }

    @RequestMapping(value="/")
    public ModelAndView listOfEmployee(){
        ModelAndView modelAndView=new ModelAndView("employee/employeeList");
        List<Employee> emlpoyees=employeeService.listEmployee();
        modelAndView.addObject("employees",emlpoyees);
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addEmployee(){
        ModelAndView modelAndView=new ModelAndView("employee/addEmployee");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/employee/");
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public ModelAndView updateEmployee(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("employee/employeeEdit");
        Employee employee=employeeService.findEmployeeById(id);
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute Employee employee,@PathVariable long id){
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/employee/");
    }

    @RequestMapping(value = "/{id}/delete",method =RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employee/");
    }
}
