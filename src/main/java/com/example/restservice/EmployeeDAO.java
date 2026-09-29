package com.example.restservice;

import org.springframework.stereotype.Repository;


// Marks this class as a Spring-managed repository component
@Repository
public class EmployeeDAO {

    // Stores employee data in memory
    private final Employees employees = new Employees();

    // Constructor used to add initial employee data
    public EmployeeDAO() {

        // Adds the first employee
        employees.getEmployees()
                .add(new Employee(1, "Prem", "Tiwari", "prem@gmail.com", "Editor"));

        // Adds the second employee
        employees.getEmployees()
                .add(new Employee(2, "Vikash", "Kumar", "vikash@gmail.com", "HR Expert"));

        // Adds the third employee
        employees.getEmployees()
                .add(new Employee(3, "Ritesh", "Ojha", "ritesh@gmail.com", "Courier"));
    }

    // Returns all employees
    public Employees getAllEmployees() {
        return employees;
    }

    // Finds an employee using the employee ID
    public Employee getEmployeeById(Integer employee_id) {

        // Searches the employee list for the specified ID
        return employees.getEmployees()
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(employee_id))
                .findFirst()
                .orElse(null);
    }

    // Adds a new employee to the list
    public void addEmployee(Employee employee) {
        employees.getEmployees().add(employee);
    }
}