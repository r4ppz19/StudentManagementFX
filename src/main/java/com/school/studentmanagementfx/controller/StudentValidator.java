package com.school.studentmanagementfx.controller;

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
            String email
    ) {
        Map<String, String> errors = new HashMap<>();
        if (id == null || id.trim().isEmpty()) {
            errors.put("id", "ID is required.");
        }
        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "Name is required.");
        }
        if (age == null || !age.matches("\\d+")) {
            errors.put("age", "Age must be a number.");
        }
        if (birthday == null || birthday.trim().isEmpty()) {
            errors.put("birthday", "Birthday is required.");
        }
        if (address == null || address.trim().isEmpty()) {
            errors.put("address", "Address is required.");
        }
        if (course == null || course.trim().isEmpty()) {
            errors.put("course", "Course is required.");
        }
        if (year == null || !year.matches("\\d+")) {
            errors.put("year", "Year must be a number.");
        }
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.put("email", "Invalid email format.");
        }
        return errors;
    }
}