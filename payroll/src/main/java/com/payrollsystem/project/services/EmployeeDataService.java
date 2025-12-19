package com.payrollsystem.project.services;

import com.payrollsystem.project.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDataService {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String FILE_PATH = "payroll/src/main/resources/employees.json";

    public static void saveToJson(ArrayList<Employee> employees) {
        try {
            File file = new File(FILE_PATH);

            // 1. Get the parent folder (e.g., src/main/resources)
            File parentDir = file.getParentFile();

            // 2. If the folder doesn't exist, create it!
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // mkdirs() creates nested folders if needed
            }

            // 3. Now write the file
            mapper.writeValue(file, employees);
            System.out.println("Data successfully saved to: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error saving JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> loadFromJson() {
        File file = new File(FILE_PATH);

        // Check if file exists and is not empty
        if (!file.exists() || file.length() == 0) {
            System.out.println("No existing data found. Starting with empty list.");
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(file, new TypeReference<ArrayList<Employee>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}