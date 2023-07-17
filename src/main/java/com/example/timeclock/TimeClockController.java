package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
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
        return new ModelAndView("/home");
    }

    @RequestMapping("/users/{id}/searchForUser")
    public ModelAndView searchForUser(@PathVariable String id) {
        ModelAndView modelAndView;
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isEmpty()) {
            modelAndView = new ModelAndView("/error/EmployeeNotFound");
        } else {
            modelAndView = new ModelAndView("redirect:/users/" + id + "/clock");
        }

        return modelAndView;
    }

    @RequestMapping("/users/{id}/clock")
    public ModelAndView clockPage(@PathVariable String id) {
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isPresent()) {
            Employee employee = query.get();
            return new ModelAndView("/clock", "employee", employee);
        } else {
            return new ModelAndView("/error/EmployeeNotFound");
        }
    }

    @RequestMapping("/users/{id}/clockIn")
    public ModelAndView clockIn(@PathVariable String id) {
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isPresent()) {
            Employee employee = query.get();
            if(employee.getClockedIn()) return new ModelAndView("/error/AlreadyClockedIn");
            dataHandler.punch(id);
            return new ModelAndView("/clockedIn");
        } else {
            return new ModelAndView("/error/EmployeeNotFound");
        }
    }

    @RequestMapping("/users/{id}/clockOut")
    public ModelAndView clockOut(@PathVariable String id) {
        Optional<Employee> query = dataHandler.findById(id);
        if(query.isPresent()) {
            Employee employee = query.get();
            if(!employee.getClockedIn()) return new ModelAndView("/error/AlreadyClockedOut");
            dataHandler.punch(id);
            return new ModelAndView("/clockedOut");
        } else {
            return new ModelAndView("/error/EmployeeNotFound");
        }
    }

    @RequestMapping("/registerPage")
    public ModelAndView registerPage() {
        return new ModelAndView("/registerPage");
    }

    @RequestMapping("/users/{firstName}/{lastName}/register")
    public ModelAndView register(@PathVariable String firstName, @PathVariable String lastName) {
        Employee employee = dataHandler.createNewUser(firstName, lastName);
        return new ModelAndView("/newUserCreated", "employee", employee);
    }
}
