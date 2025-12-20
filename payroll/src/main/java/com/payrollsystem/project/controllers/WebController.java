package com.payrollsystem.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.payrollsystem.project.models.BankAccount;
import com.payrollsystem.project.models.Employee;
import com.payrollsystem.project.models.Shift;

@Controller
public class WebController {

    private EmployeeController empController;
    private ShiftController shiftController;

    public WebController() {
        empController = new EmployeeController();
        shiftController = new ShiftController();
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
        model.addAttribute("empList", empController.getAllEmployeesWithoutAPI());
        System.out.println("routing");
        return "Employees";
    }

    @GetMapping("Shifts")
    public String ShiftPage(Model model) {
        model.addAttribute("shiftObject", new Shift());
        model.addAttribute("shiftList", shiftController.getAllShiftsWithoutAPI());
        return "Shifts";
    }

}