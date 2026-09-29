package com.example.restservice;

public class Employee {

    // Stores the employee employee_id
    private Integer employee_id;

    // Stores the employee's first name
    private String first_name;

    // Stores the employee's last name
    private String last_name;

    // Stores the employee's email address
    private String email;

    // Stores the employee's title
    private String title;

    // Default constructor required for creating an object
    public Employee() {
    }

    // Parameterized constructor for initializing employee details
    public Employee(Integer employee_id, String first_name, String last_name, String email, String title) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
    }

    // Returns the employee_id
    public Integer getEmployeeId() {
        return employee_id;
    }

    // Sets the employee_id
    public void setEmployeeId(Integer employee_id) {
        this.employee_id = employee_id;
    }

    // Returns the employee's first name
    public String getFirstName() {
        return first_name;
    }

    // Sets the employee's first name
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    // Returns the employee's last name
    public String getLastName() {
        return last_name;
    }

    // Sets the employee's last name
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    // Returns the employee's email
    public String getEmail() {
        return email;
    }

    // Sets the employee's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns the employee's title
    public String getTitle() {
        return title;
    }

    // Sets the employee's title
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns employee details as a string
    @Override
    public String toString() {
        return "Employee [id=" + employee_id
                + ",first_name=" + first_name
                + ", last_name=" + last_name
                + ", email=" + email
                + ", title=" + title +"]";
    }
}