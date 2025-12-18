package com.payrollsystem.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}