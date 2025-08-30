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
        Student student1 = new Student(
                "1",
                "John Rey Rabosa",
                "19",
                "12/31/2005",
                "Panacan Davao City",
                "BSIT",
                "2nd",
                "john.rabosa@example.com");

        Student student2 = new Student(
                "2",
                "Erwin Curato",
                "20",
                "08/15/2004",
                "Bajada Davao City",
                "BSIT",
                "3rd",
                "erwin.curato@example.com");

        Student student3 = new Student(
                "3",
                "Mark Anthony Villanueva",
                "18",
                "05/20/2006",
                "Toril Davao City",
                "BSIT",
                "1st",
                "mark.villanueva@example.com");

        Student student4 = new Student(
                "4",
                "Anna Mae Castillo",
                "21",
                "09/02/2003",
                "Matina Davao City",
                "BSIT",
                "4th",
                "anna.castillo@example.com");

        Student student5 = new Student(
                "5",
                "Christian James Delos Santos",
                "19",
                "02/18/2005",
                "Lanang Davao City",
                "BSIT",
                "2nd",
                "christian.santos@example.com");

        Student student6 = new Student(
                "6",
                "Rochelle Mae Bautista",
                "20",
                "11/10/2004",
                "Mintal Davao City",
                "BSIT",
                "3rd",
                "rochelle.bautista@example.com");

        Student student7 = new Student(
                "7",
                "Joshua Emmanuel Cruz",
                "22",
                "07/25/2002",
                "Sasa Davao City",
                "BSIT",
                "4th",
                "joshua.cruz@example.com");

        DatabaseService.addStudent(student1);
        DatabaseService.addStudent(student2);
        DatabaseService.addStudent(student3);
        DatabaseService.addStudent(student4);
        DatabaseService.addStudent(student5);
        DatabaseService.addStudent(student6);
        DatabaseService.addStudent(student7);
    }
}