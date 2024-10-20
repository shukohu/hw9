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

    private final List<Employee> employees = new ArrayList<Employee>(List.of(
            new Employee("Olga", "Petrova"),
            new Employee("Ivan", "Ivanov"),
            new Employee("Vera","Petukhova"),
            new Employee("Roman", "Smirnov"),
            new Employee("Svetlana","Glebova")));

    @Override
    public Employee add(String firstName, String lastName)
            throws EmployeeStoragesFull, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
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
    public Employee remove(String firstName, String lastName)
            throws EmployeeNotFound {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFound("This employee hasn't been found!!!");
        }
        employees.remove(employee);
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName)
            throws EmployeeNotFound {

        Employee employee = new Employee(firstName, lastName);

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

