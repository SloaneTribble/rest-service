package com.example.restservice;

public class Employee {

    // Stores the employee ID
    private Integer id;

    // Stores the employee's first name
    private String firstName;

    // Stores the employee's last name
    private String lastName;

    // Stores the employee's email address
    private String email;

    // Default constructor required for creating an object
    public Employee() {
    }

    // Parameterized constructor for initializing employee details
    public Employee(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Returns the employee ID
    public Integer getId() {
        return id;
    }

    // Sets the employee ID
    public void setId(Integer id) {
        this.id = id;
    }

    // Returns the employee's first name
    public String getFirstName() {
        return firstName;
    }

    // Sets the employee's first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Returns the employee's last name
    public String getLastName() {
        return lastName;
    }

    // Sets the employee's last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns the employee's email
    public String getEmail() {
        return email;
    }

    // Sets the employee's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns employee details as a string
    @Override
    public String toString() {
        return "Employee [id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", email=" + email + "]";
    }
}