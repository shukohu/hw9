package com.example.demo.Service;

import com.example.demo.Employee.Employee;
import com.example.demo.Exception.EmployeeAlreadyAddedException;
import com.example.demo.Exception.EmployeeNotFound;
import com.example.demo.Exception.EmployeeStoragesFull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int LIST_SIZE = 10;

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Olga", "Petrova", 63299, 1),
            new Employee("Vera", "Petukhova", 42100, 1),
            new Employee("Petr", "Kolobkov", 62000, 2),
            new Employee("Roman", "Mironov", 55200, 2),
            new Employee("Marina", "Svetlaya", 56000, 3),
            new Employee("Sergey", "Tikhonov", 87500, 3),
            new Employee("Maksim", "Pavlov", 98000, 4),
            new Employee("Evgenyi", "Zybkin", 100000, 4)
    ));


    @Override

    public Employee add(String firstName, String lastName, double salary, int department)
            throws EmployeeStoragesFull, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.size() >= LIST_SIZE) {
            throw new EmployeeStoragesFull("The list size is exceeded!!!");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Such an employee already exists!!!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFound {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName, double salary, int department)
            throws EmployeeNotFound {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFound("This employee hasn't been found!!!");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) throws EmployeeNotFound {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeStoragesFull, EmployeeAlreadyAddedException {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFound {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, double salary, int department)
            throws EmployeeNotFound {

        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFound("This employee has not been found");
    }

    @Override
    public List<Employee> getAll() {
        return employees;

    }
}

