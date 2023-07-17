package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TimeClockController {
    private final TimeClockDataHandler dataHandler;
    @Autowired
    public TimeClockController(TimeClockDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @RequestMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home");
        return modelAndView;
    }

    @RequestMapping("/users/{id}/searchForUser")
    public ModelAndView searchForUser(@PathVariable String id) {
        ModelAndView modelAndView;
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isEmpty()) {
            modelAndView = new ModelAndView("redirect:/error/EmployeeNotFound");
        } else {
            modelAndView = new ModelAndView("redirect:/users/" + id + "/clock");
        }

        return modelAndView;
    }

    @RequestMapping("/error/EmployeeNotFound")
    public ModelAndView employeeNotFoundPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/EmployeeNotFound");
        return modelAndView;
    }

    @RequestMapping("/users/{id}/clock")
    public ModelAndView clockPage(@PathVariable String id) {
        Employee employee = dataHandler.findById(id).get();
        return new ModelAndView("/clock", "employee", employee);
    }
}
