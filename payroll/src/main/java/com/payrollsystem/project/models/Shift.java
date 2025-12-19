package com.payrollsystem.project.models;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Shift {
    private String shiftName;
    private String startTime;
    private String endTime;

    public Shift() {

    }

    public Shift(String shiftName, String startTime, String endTime) {
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonIgnore
    public double getDurationHours() {
        if (startTime == null || endTime == null)
            return 0;

        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);

        long minutes = ChronoUnit.MINUTES.between(start, end);
        if (minutes < 0)
            minutes += 1440; // Handle midnight cross

        return minutes / 60.0;
    }

    @JsonIgnore
    public String getShiftDetails() {
        return "Shift ID: " + shiftName + "Start Time: " + startTime + "End Time: " + endTime + "Duration (hours): "
                + getDurationHours();
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "Shift [" + shiftName + "]: " + startTime + " to " + endTime;
    }
}