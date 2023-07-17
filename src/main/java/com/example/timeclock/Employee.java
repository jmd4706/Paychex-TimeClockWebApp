package com.example.timeclock;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    @Id
    private String id;
    private final String firstName;
    private final String lastName;
    private Boolean clockedIn;
    public List<String> punchRecord;

    public String getId() { return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public Boolean getClockedIn() {return clockedIn;}
    public List<String> getPunchRecord() {return punchRecord;}

    public Employee(String firstName, String lastName) {
        this.id = String.valueOf(newEmployeeId());
        this.firstName = firstName;
        this.lastName = lastName;
        this.clockedIn = false;
        this.punchRecord = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s', clockedIn='%s']",
                id, firstName, lastName, clockedIn);
    }

    private int newEmployeeId() {
        int minEmployeeId = 10000;
        int maxEmployeeId = 99999;
        return (int) ((Math.random() * (maxEmployeeId - minEmployeeId)) + minEmployeeId);
    }

    public void punch() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = LocalDateTime.now().format(formatter);
        clockedIn = !clockedIn;
        punchRecord.add(date);
    }
}
