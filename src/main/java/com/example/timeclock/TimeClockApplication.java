package com.example.timeclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TimeClockApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(TimeClockApplication.class, args);
    }

    @Override
    public void run(String... args) {
        repository.findById("52354");
    }
}
