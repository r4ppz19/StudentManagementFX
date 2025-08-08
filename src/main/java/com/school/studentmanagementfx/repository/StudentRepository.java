package com.school.studentmanagementfx.repository;

import com.school.studentmanagementfx.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRepository {
    private static final ObservableList<Student> students = FXCollections.observableArrayList();

    public static ObservableList<Student> getStudents() {
        return students;
    }
}
