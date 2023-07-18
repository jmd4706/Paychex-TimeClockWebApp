package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * The controller that handles all client requests
 */
@Controller
public class TimeClockController {
    private final TimeClockDataHandler dataHandler;
    @Autowired
    public TimeClockController(TimeClockDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    /**
     * Sends the home page to the client
     * @return the ModelAndView resolved by Spring
     */
    @RequestMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView("/home");
    }

    /**
     * Searches the database for an Employee with the specified id
     * @param id: the Employee's id
     * @return the ModelAndView resolved by Spring
     */
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

    /**
     * Sends the clock page to the client
     * @param id: the Employee's id
     * @return the ModelAndView resolved by Spring
     */
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

    /**
     * Clocks in an Employee
     * @param id: the Employee's id
     * @return the ModelAndView resolved by Spring
     */
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

    /**
     * Clocks out an Employee
     * @param id: the Employee's id
     * @return the ModelAndView resolved by Spring
     */
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

    /**
     * Sends the register page to the client
     * @return the ModelAndView resolved by Spring
     */
    @RequestMapping("/registerPage")
    public ModelAndView registerPage() {
        return new ModelAndView("/registerPage");
    }

    /**
     * Registers a new employee
     * @return the ModelAndView resolved by Spring
     */
    @RequestMapping("/users/{firstName}/{lastName}/register")
    public ModelAndView register(@PathVariable String firstName, @PathVariable String lastName) {
        Employee employee = dataHandler.createNewUser(firstName, lastName);
        return new ModelAndView("/newUserCreated", "employee", employee);
    }
}
