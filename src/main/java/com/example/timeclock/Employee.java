package com.example.timeclock;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Employee {

    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String creationDate;
    public Boolean clockedIn;

    public String getId() { return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public Boolean getClockedIn() {return clockedIn;}

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
        int minEmployeeId = 10000;
        int maxEmployeeId = 99999;
        return (int) ((Math.random() * (maxEmployeeId - minEmployeeId)) + minEmployeeId);
    }
}
