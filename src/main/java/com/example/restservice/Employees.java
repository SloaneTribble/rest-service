package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

// Class used to store a list of employees
public class Employees {

    // Creates an empty list to store employee objects
    private List<Employee> employeeList = new ArrayList<>();

    // Returns the list of employees
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    // Updates the employee list
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}