package com.example.demo.Controller;

import com.example.demo.Employee.Employee;
import com.example.demo.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dep")
public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer departmentId) {
       return departmentService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer departmentId){
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/departments")
    public List<Employee> departments(@RequestParam Integer departmentId) {
        return departmentService.departments(departmentId);
    }

    @GetMapping
    public Map<Integer, List<Employee>> getEmployeeDepartments() {
        return departmentService.getEmployeeDepartments();
    }
}

