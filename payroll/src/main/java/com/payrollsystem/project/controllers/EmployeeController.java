package com.payrollsystem.project.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.payrollsystem.project.models.Employee;
import com.payrollsystem.project.services.DataService;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private ArrayList<Employee> employeeList;

    public EmployeeController() {
        employeeList = loadFromJSON();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        this.employeeList.add(employee);
        System.out.println("Saving employee: " + employee.getFirstName());
        saveToJSON();
        return "redirect:/";
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

    public void saveToJSON() {
        DataService.saveToJson(employeeList);
    }

    public ArrayList<Employee> loadFromJSON() {
        return DataService.loadFromJson();
    }
}
