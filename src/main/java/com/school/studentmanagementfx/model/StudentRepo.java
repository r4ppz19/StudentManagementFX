package com.school.studentmanagementfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRepo {
    private static final ObservableList<Student> students = FXCollections.observableArrayList();

    public static ObservableList<Student> getStudents() {
        return students;
    }
}
