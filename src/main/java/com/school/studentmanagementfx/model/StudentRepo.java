package com.school.studentmanagementfx.model;

import com.school.studentmanagementfx.service.DatabaseService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRepo {

    private static final ObservableList<Student> students = FXCollections.observableArrayList();

    public static ObservableList<Student> getStudents() {
        return students;
    }

    // For testing
    public static void createDummyStudent() {
        for (int i = 1; i <= 7; i++) {
            if (DatabaseService.findStudentById(String.valueOf(i)) == null) {
                Student dummy = new Student(
                        String.valueOf(i),
                        "Dummy Name",
                        "20",
                        "12/31/2005",
                        "Prk " + i + "Address",
                        "BSIT",
                        "2nd",
                        "dummy" + i + "@example.com");
                DatabaseService.addStudent(dummy);
            }
        }
    }
}