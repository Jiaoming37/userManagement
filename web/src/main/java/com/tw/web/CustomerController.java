package com.tw.web;

import com.tw.core.Customer;
import com.tw.core.Employee;
import com.tw.core.Course;
import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by jiaoming on 6/30/15.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    private EmployeeService employeeService;
    private CourseService courseService;


    @Autowired
    public CustomerController(CustomerService customerService,EmployeeService employeeService,CourseService courseService){
        this.customerService=customerService;
        this.employeeService=employeeService;
        this.courseService=courseService;
    }

    @RequestMapping("/all")
    public List<Customer> listCustomer(){
        return customerService.listCustomer();
    }

    @RequestMapping("/")
    public ModelAndView listOfCustomer(){
        ModelAndView modelAndView=new ModelAndView("customer/customerList");
        List<Customer> customers=customerService.listCustomer();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public ModelAndView addCustomer(){
        ModelAndView modelAndView=new ModelAndView("customer/addCustomer");
        modelAndView.addObject("customer",new Customer());
        List<Employee> coaches=employeeService.listCoach();
        modelAndView.addObject("coaches",coaches);
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return new ModelAndView("redirect:/customer/");
    }

    @RequestMapping(value = "/{id}/edit",method =RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("customer/customerEdit");
        Customer customer=customerService.findCustomerById(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView editCustomer(@PathVariable long id,@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customer/");
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customer/");
    }

    @RequestMapping(value="/{id}/select",method = RequestMethod.GET)
    public ModelAndView checkCourse(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("customer/selectCourse");
        modelAndView.addObject("course",new Course());
        List<Course> courses=courseService.listCourse();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/select",method = RequestMethod.POST)
    public ModelAndView checkCourse(@PathVariable long id,@ModelAttribute Course course){
        Customer customer=customerService.findCustomerById(id);
        Course selectedCourse=courseService.findCourseById(course.getId());
        customer.getCourses().add(selectedCourse);
        selectedCourse.getCustomers().add(customer);
        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customer/");
    }

}
