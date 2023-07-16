package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/users/{id}")
    public ModelAndView clockPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isPresent()) {
            Employee employee = query.get();
            System.out.println(employee);
        }

        return modelAndView;
    }

}
