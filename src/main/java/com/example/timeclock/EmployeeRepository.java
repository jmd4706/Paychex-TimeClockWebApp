package com.example.timeclock;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * An interface used by Spring for autowiring MongoDB queries to the TimeClockDataHandler
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    /**
     * A method implemented by Spring to query the database for an Employee with the specified id
     * @param id: the Employee's id
     * @return an Optional object containing either the found employee, or nothing
     */
    Optional<Employee> findEmployeeById(String id);
}
