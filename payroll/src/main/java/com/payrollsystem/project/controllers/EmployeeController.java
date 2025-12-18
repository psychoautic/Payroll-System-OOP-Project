package com.payrollsystem.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @GetMapping("/ahmed")
    public String getAhmed() {
        return "index";
    }
}
