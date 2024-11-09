package com.example.demo.Service;

import com.example.demo.Employee.Employee;
import com.example.demo.Exception.EmployeeAlreadyAddedException;
import com.example.demo.Exception.EmployeeNotFound;
import com.example.demo.Exception.EmployeeStoragesFull;

import java.util.List;

public interface EmployeeService {
    Employee remove(String firstName, String lastName, double salary, int department) throws EmployeeNotFound;

    Employee find(String firstName, String lastName, int department, double salary)
            throws EmployeeNotFound;

    public Employee add(String firstName, String lastName)
            throws EmployeeStoragesFull, EmployeeAlreadyAddedException;

    public Employee remove(String firstName, String lastName)
            throws EmployeeNotFound;

    public Employee find(String firstName, String lastName, double salary, int department)
            throws EmployeeNotFound;

    Employee add(String firstName, String lastName, double salary, int department) throws EmployeeStoragesFull, EmployeeAlreadyAddedException;

    Employee find(String firstName, String lastName) throws EmployeeNotFound;

    List<Employee> getAll();
}
