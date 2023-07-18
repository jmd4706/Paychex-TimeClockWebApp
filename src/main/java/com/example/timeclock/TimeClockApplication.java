package com.example.timeclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main TimeClock application class
 */
@SpringBootApplication
public class TimeClockApplication {

    /**
     * Main method that runs the Spring application
     * @param args: additional command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(TimeClockApplication.class, args);
    }
}
