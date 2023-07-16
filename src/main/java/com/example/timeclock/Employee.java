package com.example.timeclock;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Random;

public class Employee {
    private Integer minEmployeeId = 10000;
    private Integer maxEmployeeId = 99999;

    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String creationDate;
    public Boolean clockedIn;

    public Employee() {};

    public Employee(String firstName, String lastName) {
        this.id = String.valueOf(newEmployeeId());
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = String.valueOf(LocalDateTime.now());
        this.clockedIn = false;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s', creationDate='%s', clockedIn='%s']",
                id, firstName, lastName, creationDate, clockedIn);
    }

    private int newEmployeeId() {
        return (int) ((Math.random() * (maxEmployeeId - minEmployeeId)) + minEmployeeId);
    }
}
