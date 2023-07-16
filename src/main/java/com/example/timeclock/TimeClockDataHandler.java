package com.example.timeclock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeClockDataHandler {

    @Autowired
    private EmployeeRepository repository;

    public Optional<Employee> findById(String id) {
//        repository.deleteAll();
//        repository.save(new Employee("John", "Smith"));
//        repository.save(new Employee("Ron", "Doe"));
//        repository.save(new Employee("Jack", "Daniels"));
//        repository.save(new Employee("Peter", "Englert"));
//        repository.save(new Employee("Sally", "Briggs"));

        return repository.findEmployeeById(id);
    }
}
