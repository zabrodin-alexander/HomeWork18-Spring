package com.example.Employees.controller;

import com.example.Employees.model.Employee;
import com.example.Employees.service.DepartmentService;
import com.example.Employees.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add-data")
    public void addTestData() {
        employeeService.addTestData();
        return;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeMaxSalaryByDepartment(@RequestParam("departmentId") String department) {
        return departmentService.getEmployeeMaxSalaryByDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalaryByDepartment(@RequestParam("departmentId") String department) {
        return departmentService.getEmployeeMinSalaryByDepartment(department);
    }

    @GetMapping("/all")
    public Map<String, List<Employee>> getAllEmployeesByDepartment(@RequestParam(value = "departmentId", required = false) String department) {
        if (department == null) {
            return departmentService.getAllEmployeesByDepartments();
        }
        return departmentService.getAllEmployeesByDepartment(department);
    }
}
