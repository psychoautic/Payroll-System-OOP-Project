package com.payrollsystem.project.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payrollsystem.project.models.Shift;
import com.payrollsystem.project.services.ShiftDataService;

@Controller
@RequestMapping("/api/shift")
public class ShiftController {

    private ArrayList<Shift> shiftList;

    public ShiftController() {
        shiftList = loadFromJSON();
    }

    @PostMapping("/addShift")
    public String addShift(@ModelAttribute Shift shift) {
        shift.setShiftID();
        this.shiftList.add(shift);

        saveToJSON();
        return "redirect:/Shifts";
    }

    public ArrayList<Shift> getAllShiftsWithoutAPI() {
        shiftList = loadFromJSON();
        if (shiftList.size() > 0) {
            System.out.println("Sending shifts lists" + shiftList.get(0).getShiftDetails());
        } else {
            System.out.println("Shift list is empty");
        }
        return shiftList;
    }

    public Shift searchForShift(int id) {
        for (int i = 0; i < shiftList.size(); i++) {
            if (shiftList.get(i).getShiftID() == id) {
                return shiftList.get(i);
            }
        }
        return shiftList.get(0);
    }

    public void saveToJSON() {
        ShiftDataService.saveToJson(shiftList);
    }

    public ArrayList<Shift> loadFromJSON() {
        return ShiftDataService.loadFromJson();
    }
}
