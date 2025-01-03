package com.example.Employees.service;

import com.example.Employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeMaxSalaryByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeMinSalaryByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
