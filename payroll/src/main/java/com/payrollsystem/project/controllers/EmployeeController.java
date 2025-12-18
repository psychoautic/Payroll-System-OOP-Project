package com.payrollsystem.project.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payrollsystem.project.models.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private ArrayList<Employee> employeeList;

    public EmployeeController() {
        employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(353, "Eyad", "Mahmoud", 4500, "CIB", 432, "HIT0000JAHV480000JJ", "JJWW31C"));
        employeeList.add(new Employee(945, "Mahmoud", "Hesham", 5400, "AlAhly", 133, "FRR00KALV460070AJ", "EER3TT2"));
    }

    public ArrayList<Employee> getAllEmployeesWithoutAPI() {
        return employeeList;
    }

    public double getTotalCompanyPayout() {
        double amount = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            amount += employeeList.get(i).calculatePay();
        }

        return amount;
    }
}
