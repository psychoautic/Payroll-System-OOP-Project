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
import com.payrollsystem.project.models.PartTimeEmployee;
import com.payrollsystem.project.models.Shift;
import com.payrollsystem.project.models.Form;
import com.payrollsystem.project.models.FullTimeEmployee;
import com.payrollsystem.project.services.EmployeeDataService;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private ArrayList<Employee> employeeList;
    private ShiftController shiftController;

    public EmployeeController() {
        employeeList = loadFromJSON();
        shiftController = new ShiftController();

    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Form form) {

        Employee employee;
        Shift shift = shiftController.searchForShift(form.getShiftID());
        if (form.getType().equals("No Type")) {
            employee = new Employee(form.employeeId, form.firstName, form.lastName, form.baseSalary,
                    form.bankName, form.bankNumber, form.Iban, form.swift);
        } else if (form.getType().equals("Full-Time")) {
            employee = new FullTimeEmployee(form.employeeId, form.firstName, form.lastName, form.annualBonus,
                    form.baseSalary,
                    form.bankName, form.bankNumber, form.Iban, form.swift);
        } else {
            employee = new PartTimeEmployee(form.employeeId, form.firstName, form.lastName,
                    form.baseSalary, form.hourlyRate, shift.getDurationHours(),
                    form.bankName, form.bankNumber, form.Iban, form.swift);
        }

        employee.setShift(shift);
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
                break;
            }

        }
        saveToJSON();
        return "redirect:/Employees";
    }

    @GetMapping("/payEmployee/{id}")
    public String payEmployee(@PathVariable("id") int id) {
        for (int i = 0; i < this.employeeList.size(); i++) {
            if (id == this.employeeList.get(i).getEmployeeId()) {
                this.employeeList.get(i).setPayStatus(true);
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
