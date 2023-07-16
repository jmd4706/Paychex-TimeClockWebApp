package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TimeClockController {
    @Autowired
    private TimeClockDataHandler dataHandler;

    @RequestMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @RequestMapping("/users/{id}/searchForUser")
    public ModelAndView searchForUser(@PathVariable String id) {
        ModelAndView modelAndView;
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isEmpty()) {
            modelAndView = new ModelAndView("redirect:/error/EmployeeNotFound");
        } else {
            Employee employee = query.get();
            modelAndView = new ModelAndView("redirect:/users/" + id + "/clock");
            System.out.println(employee);
        }

        return modelAndView;
    }

    @RequestMapping("/error/EmployeeNotFound")
    public ModelAndView employeeNotFoundPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EmployeeNotFound.html");
        return modelAndView;
    }

    @RequestMapping("/users/{id}/clock")
    public ModelAndView clockPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../../clock.html");
        return modelAndView;
    }

}
