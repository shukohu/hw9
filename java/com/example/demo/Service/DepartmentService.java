package com.example.demo.Service;

import com.example.demo.Employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(Integer departmentId);

    Employee minSalary(Integer departmentId);

    List<Employee> departments(Integer departmentId);

    Map<Integer, List<Employee>> getEmployeeDepartments();
}
