package com.example.demo.Service;

import com.example.demo.Employee.Employee;
import com.example.demo.Exception.EmployeeAlreadyAddedException;
import com.example.demo.Exception.EmployeeNotFound;
import com.example.demo.Exception.EmployeeStoragesFull;

import java.util.List;

public interface EmployeeService {
    public Employee add(String firstName, String lastName)
            throws EmployeeStoragesFull, EmployeeAlreadyAddedException;

    public Employee remove(String firstName, String lastName)
            throws EmployeeNotFound;

    public Employee find(String firstName, String lastName)
            throws EmployeeNotFound;

    List<Employee> getAll();
}
