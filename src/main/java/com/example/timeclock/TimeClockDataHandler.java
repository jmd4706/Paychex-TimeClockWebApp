package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeClockDataHandler {

    private final EmployeeRepository repository;
    @Autowired
    public TimeClockDataHandler(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Optional<Employee> findById(String id) {
        return repository.findEmployeeById(id);
    }

    public Employee createNewUser(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        repository.save(employee);
        return employee;
    }

    public void punch(String id) {
        Optional<Employee> query = repository.findEmployeeById(id);
        if(query.isPresent()) {
            Employee employee = query.get();
            employee.punch();
            repository.save(employee);
        }

    }
}
