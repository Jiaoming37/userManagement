package com.tw.web;

import com.tw.core.Course;
import com.tw.core.CourseTime;
import com.tw.core.Employee;
import com.tw.core.service.CourseService;
import com.tw.core.service.CourseTimeService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jiaoming on 6/30/15.
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;
    private EmployeeService employeeService;
    private CourseTimeService courseTimeService;

    @Autowired
    public CourseController(CourseService courseService,EmployeeService employeeService,CourseTimeService courseTimeService){
        this.courseService=courseService;
        this.employeeService=employeeService;
        this.courseTimeService=courseTimeService;
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
        List<Employee> coaches=employeeService.listCoach();
        modelAndView.addObject("coaches",coaches);
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute Course course){
        courseService.addCourse(course);
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public ModelAndView courseEdit(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("course/courseEdit");
        Course course=courseService.findCourseById(id);
        modelAndView.addObject("course",course);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView courseEdit(@PathVariable long id,@ModelAttribute Course course){
        courseService.updateCourse(course);
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/addTime",method = RequestMethod.GET)
    public ModelAndView addTime(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("course/addTime");
        modelAndView.addObject("courseTime",new CourseTime());
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/addTime",method = RequestMethod.POST)
    public ModelAndView addTime(@PathVariable long id,@ModelAttribute CourseTime courseTime){
        Course course=courseService.findCourseById(id);
        courseTime.setCourse(course);
        courseTimeService.addCourseTime(courseTime);
        course.getCourseTimes().add(courseTime);
        return new ModelAndView("redirect:/course/");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
