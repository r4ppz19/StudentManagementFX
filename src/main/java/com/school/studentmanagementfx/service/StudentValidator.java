package com.school.studentmanagementfx.service;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class StudentValidator {
    public static Map<String, String> validateStudentFields(
            String id,
            String name,
            String age,
            String birthday,
            String address,
            String course,
            String year,
            String email) {

        Map<String, String> errors = new HashMap<>();

        if (id == null || id.trim().isEmpty()) {
            errors.put("id", "ID required");
        } else if (!id.matches("\\d+")) {
            errors.put("id", "Invalid ID");
        }
        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "Name required");
        } else if (!name.matches("^[A-Za-z ]+$")) {
            errors.put("name", "Invalid format");
        }
        if (age == null || age.trim().isEmpty()) {
            errors.put("age", "Age required");
        } else if (!age.matches("\\d+")) {
            errors.put("age", "Invalid age");
        }
        if (birthday == null || birthday.trim().isEmpty()) {
            errors.put("birthday", "Birthday required");
        } else if (!birthday.matches("^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$")) {
            errors.put("birthday", "Invalid format");
        }
        if (address == null || address.trim().isEmpty()) {
            errors.put("address", "Address required");
        }
        if (course == null || course.trim().isEmpty()) {
            errors.put("course", "Course required");
        }
        if (year == null || year.trim().isEmpty()) {
            errors.put("year", "Year required");
        }
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email required");
        } else if (!email.matches("[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,4}")) {
            errors.put("email", "Invalid email");
        }
        return errors;
    }

    public static Map<String, String> validateStudentIdUniqueness(
            String id,
            String name,
            String age,
            String birthday,
            String address,
            String course,
            String year,
            String email) {

        Map<String, String> errors = new HashMap<>();

        if (!isIdUnique(id)) {
            errors.put("id", "ID already exists");
        }
        return errors;
    }

    private static boolean isIdUnique(String id) {
        ObservableList<Student> students = StudentRepo.getStudents();
        return students.stream().noneMatch(student -> student.getId().get().equals(id));
    }
}
