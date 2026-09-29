package com.example.restservice;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Marks this class as a REST controller
@RestController

// Maps all endpoints in this controller to /employees
@RequestMapping("/employees")
public class EmployeeController {

    // Stores the EmployeeDAO dependency
    private final EmployeeDAO employeeDao;

    // Constructor injection for EmployeeDAO
    public EmployeeController(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    // Handles GET requests to /employees
    @GetMapping
    public Employees getEmployees() {

        // Returns all employees
        return employeeDao.getAllEmployees();
    }

    // Handles GET requests to /employees/{employee_id}
    @GetMapping("/{employee_id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer employee_id) {

        // Finds an employee using the specified ID
        Employee employee = employeeDao.getEmployeeById(employee_id);

        // Returns 404 if the employee does not exist
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        // Returns the employee with HTTP 200 OK
        return ResponseEntity.ok(employee);
    }

    // Handles POST requests to /employees
    @PostMapping
    public ResponseEntity<Void> addEmployee(
            @RequestBody Employee employee) {

        // Adds the employee to the list
        employeeDao.addEmployee(employee);

        // Creates the URL of the newly created employee
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployeeId())
                .toUri();

        // Returns HTTP 201 Created with the resource location
        return ResponseEntity.created(location).build();
    }
}