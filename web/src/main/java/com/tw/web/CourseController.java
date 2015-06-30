package com.tw.web;

import com.tw.core.Course;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by jiaoming on 6/30/15.
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @RequestMapping("/all")
    public List<Course> listCourse(){
        return courseService.listCourse();
    }

    @RequestMapping("/")
    public ModelAndView listOfCourse(){
        ModelAndView modelAndView=new ModelAndView("course/courseList");
        List<Course> courses=courseService.listCourse();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addCourse(){
        ModelAndView modelAndView=new ModelAndView("course/addCourse");
        modelAndView.addObject("course",new Course());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute Course course){
        ModelAndView modelAndView=new ModelAndView("course/courseList");
        courseService.addCourse(course);
        List<Course> courses=courseService.listCourse();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public ModelAndView courseEdit(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("course/courseEdit");
        Course course=courseService.findCustomerById(id);
        modelAndView.addObject("course",course);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView courseEdit(@PathVariable long id,@ModelAttribute Course course){
        ModelAndView modelAndView=new ModelAndView("course/courseList");
        courseService.updateCourse(course);
        List<Course> courses=courseService.listCourse();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("course/courseList");
        courseService.deleteCourse(id);
        List<Course> courses=courseService.listCourse();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }
}
