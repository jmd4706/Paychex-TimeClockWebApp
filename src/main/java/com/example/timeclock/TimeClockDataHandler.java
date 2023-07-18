package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeClockDataHandler {

    private final EmployeeRepository repository;

    /**
     * Class constructor
     * @param repository: the EmployeeRepository used to communicate directly with the MongoDB database
     */
    @Autowired
    public TimeClockDataHandler(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Queries database for Employee with specified id
     * @param id: employee id
     * @return an Optional object containing either the found employee, or nothing
     */
    public Optional<Employee> findById(String id) {
        return repository.findEmployeeById(id);
    }

    /**
     * Creates a new Employee and stores it in the database
     * @param firstName: Employee's first name
     * @param lastName: Employee's last name
     * @return the new Employee object
     */
    public Employee createNewUser(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        repository.save(employee);
        return employee;
    }

    /**
     * Punches (or clocks) an employee in or out (both cases are handled identically)
     * @param id: the Employee's id
     */
    public void punch(String id) {
        Optional<Employee> query = repository.findEmployeeById(id);
        if(query.isPresent()) {
            Employee employee = query.get();
            employee.punch();
            repository.save(employee);
        }
    }
}
