package com.school.studentmanagementfx.service;

import java.util.HashMap;
import java.util.Map;

public class StudentValidator {
    public static Map<String, String> validateFields(
            String id,
            String name,
            String age,
            String birthday,
            String address,
            String course,
            String year,
            String email) {
        Map<String, String> errors = new HashMap<>();
        if (id == null || !id.matches("\\d+")) {
            errors.put("id", "ID must be a number");
        }
        if (name == null || !name.matches("^[A-Za-z ]+$")) {
            errors.put("name", "Name must be a letter");
        }
        if (age == null || !age.matches("\\d+")) {
            errors.put("age", "Age must be a number");
        }
        if (birthday == null || !birthday.matches("^(0[1-9]|1[0-2])/(01-9]|[12][0-9]|3[01])/\\d{4}$")) {
            errors.put("birthday", "Invalid MM/DD/YYYY format");
        }
        if (address == null || address.trim().isEmpty()) {
            errors.put("address", "Address is required.");
        }
        if (course == null || course.trim().isEmpty()) {
            errors.put("course", "Course is required");
        }
        if (year == null || year.trim().isEmpty()) {
            errors.put("year", "Year is required");
        }
        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.put("email", "Invalid email format");
        }
        return errors;
    }
}