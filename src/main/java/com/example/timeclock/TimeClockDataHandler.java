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

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee createNewUser(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        repository.save(employee);
        return employee;
    }
}
