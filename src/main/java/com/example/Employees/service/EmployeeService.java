package com.example.Employees.service;

import com.example.Employees.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static Map<String, Employee> employees;

    public EmployeeService() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        employees.put(fullName, employee);
    }

    public void removeEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        employees.remove(fullName);
    }

    public Employee findEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        return employees.get(fullName);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public static void addTestData() {
        employees.put("Иванов", new Employee("Иван", "Иванов", 25000, "1"));
        employees.put("Петров", new Employee("Петр", "Петров", 40000, "1"));
        employees.put("Сидоров", new Employee("Егор", "Сидоров", 85000, "2"));
    }
}
