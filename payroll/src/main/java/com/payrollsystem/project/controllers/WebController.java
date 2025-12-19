package com.payrollsystem.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.payrollsystem.project.models.BankAccount;
import com.payrollsystem.project.models.Employee;

@Controller
public class WebController {

    private EmployeeController empController;

    public WebController() {
        empController = new EmployeeController();
    }

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("numberOfEmp", empController.getAllEmployeesWithoutAPI().size());
        model.addAttribute("totalPayout", empController.getTotalCompanyPayout());
        model.addAttribute("empList", empController.getAllEmployeesWithoutAPI());
        return "index";
    }

    @GetMapping("Employees")
    public String EmployeePage(Model model) {
        Employee employee = new Employee();
        employee.setBankAccount(new BankAccount());
        model.addAttribute("employee", employee);
        System.out.println("routing");
        return "Employees";
    }

}