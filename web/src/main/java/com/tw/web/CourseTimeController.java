package com.tw.web;

import com.tw.core.CourseTime;
import com.tw.core.service.CourseTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jiaoming on 7/1/15.
 */
@RestController
@RequestMapping("/courseTime")
public class CourseTimeController {

    private CourseTimeService courseTimeService;

    @Autowired
    public CourseTimeController(CourseTimeService courseTimeService){
        this.courseTimeService=courseTimeService;
    }

    @RequestMapping("/all")
    public List<CourseTime> listCourseTime(){
        return courseTimeService.listCourseTime();
    }

    @RequestMapping("/")
    public ModelAndView listOfCourseTime(){
        ModelAndView modelAndView=new ModelAndView("courseTime/courseTimeList");
        List<CourseTime> courseTimes=courseTimeService.listCourseTime();
        modelAndView.addObject("courseTimes",courseTimes);
        return modelAndView;
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public ModelAndView addCourseTime(){
        ModelAndView modelAndView=new ModelAndView("courseTime/addCourseTime");
        modelAndView.addObject("courseTime",new CourseTime());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCourseTime(@ModelAttribute CourseTime courseTime){
        ModelAndView modelAndView=new ModelAndView("courseTime/courseTimeList");
        courseTimeService.addCourseTime(courseTime);
        List<CourseTime> courseTimes=courseTimeService.listCourseTime();
        modelAndView.addObject("courseTimes",courseTimes);
        return modelAndView;
    }

    @RequestMapping(value="/{id}/edit",method = RequestMethod.GET)
    public ModelAndView editCourseTime(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("courseTime/courseTimeEdit");
        CourseTime courseTime=courseTimeService.findCourseTimeById(id);
        modelAndView.addObject("courseTime",courseTime);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView editCourseTime(@PathVariable long id,@ModelAttribute CourseTime courseTime){
        ModelAndView modelAndView=new ModelAndView("courseTime/courseTimeList");
        courseTimeService.updateCourseTime(courseTime);
        List<CourseTime> courseTimes=courseTimeService.listCourseTime();
        modelAndView.addObject("courseTimes",courseTimes);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
    public ModelAndView deleteCourseTime(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("courseTime/courseTimeList");
        courseTimeService.deleteCourseTime(id);
        List<CourseTime> courseTimes=courseTimeService.listCourseTime();
        modelAndView.addObject("courseTimes",courseTimes);
        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
