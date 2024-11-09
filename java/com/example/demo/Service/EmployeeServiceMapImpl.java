package com.example.demo.Service;

import com.example.demo.Employee.Employee;
import com.example.demo.Exception.EmployeeAlreadyAddedException;
import com.example.demo.Exception.EmployeeNotFound;
import com.example.demo.Exception.EmployeeStoragesFull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceMapImpl implements EmployeeService {

    private final int LIST_SIZE = 10;

    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Olga Petrova", new Employee("Olga", "Petrova", 63299, 1),
            "Vera Petukhova", new Employee("Vera", "Petukhova", 42100, 1),
            "Petr Kolobkov", new Employee("Petr", "Kolobkov", 62000, 2),
            "Roman Mironov", new Employee("Roman", "Mironov", 55200, 2),
            "Marina Svetlaya", new Employee("Marina", "Svetlaya", 56000, 3),
            "Sergey Tikhonov", new Employee("Sergey", "Tikhonov", 87500, 3),
            "Maksim Pavlov", new Employee("Maksim", "Pavlov", 98000, 4),
            "Evgenyi Zybkin", new Employee("Evgenyi", "Zybkin", 100000, 4)
    ));
    private final DepartmentServiceImpl departmentServiceImpl;

    public EmployeeServiceMapImpl(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @Override
    public Employee add(String firstName, String lastName, double salary, int department) throws EmployeeStoragesFull, EmployeeAlreadyAddedException {
        
        
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.size()>= LIST_SIZE) {
            throw new EmployeeStoragesFull("The list size is exceeded");
        }
        if (employees.containsKey(keyGen(firstName,lastName, salary, department))) {
            throw new EmployeeAlreadyAddedException("Employee already exists");
        }
        employees.put(keyGen(firstName, lastName, salary, department), employee);
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName, double salary, int department) throws EmployeeNotFound {
        Employee employee = new Employee (firstName,lastName, salary, department);
        if (!employees.containsKey(keyGen(firstName,lastName, salary, department))) {
            throw new EmployeeNotFound("Employee not found");
        }
        employees.remove(keyGen(firstName,lastName, salary, department));
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) throws EmployeeNotFound {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, double salary, int department) throws EmployeeNotFound {
        Employee employee = new Employee(firstName, lastName,salary, department);

        if (employees.containsKey(keyGen(firstName, lastName, salary, department))) {
            return employee;
        }
        throw new EmployeeNotFound("This employee has not been found");
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
    public Employee find(String firstName, String lastName) throws EmployeeNotFound {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
    private String keyGen(String firstName, String lastName, double salary, int department) {
        return firstName + " " + lastName;
    }
}
