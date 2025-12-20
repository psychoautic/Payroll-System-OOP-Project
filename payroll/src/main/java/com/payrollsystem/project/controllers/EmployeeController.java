package com.payrollsystem.project.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.payrollsystem.project.models.Employee;
import com.payrollsystem.project.services.EmployeeDataService;

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

    @GetMapping("/removeEmployee/{id}")
    public String removeEmployee(@PathVariable("id") int id) {
        for (int i = 0; i < this.employeeList.size(); i++) {
            if (id == this.employeeList.get(i).getEmployeeId()) {
                this.employeeList.remove(i);
            }

        }
        saveToJSON();
        return "redirect:/Employees";
    }

    public ArrayList<Employee> getAllEmployeesWithoutAPI() {
        employeeList = loadFromJSON();
        return employeeList;
    }

    public double getTotalCompanyPayout() {
        double amount = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getPayStatus()) {
                amount += employeeList.get(i).calculatePay();
            }
        }

        return amount;
    }

    public void saveToJSON() {
        EmployeeDataService.saveToJson(employeeList);
    }

    public ArrayList<Employee> loadFromJSON() {
        return EmployeeDataService.loadFromJson();
    }
}
