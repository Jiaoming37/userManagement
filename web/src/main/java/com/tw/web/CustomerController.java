package com.tw.web;

import com.tw.core.Customer;
import com.tw.core.service.CustomerService;
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

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
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
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCustomer(@ModelAttribute Customer customer){
        ModelAndView modelAndView=new ModelAndView("customer/customerList");
        customerService.addCustomer(customer);
        List<Customer> customers = customerService.listCustomer();
        modelAndView.addObject("customers",customers);
        return modelAndView;
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
        ModelAndView modelAndView=new ModelAndView("customer/customerList");
        customerService.updateCustomer(customer);
        List<Customer> customers=customerService.listCustomer();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("customer/customerList");
        customerService.deleteCustomer(id);
        List<Customer> customers=customerService.listCustomer();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
