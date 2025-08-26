package com.school.studentmanagementfx.model;

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
                "12/31/2005", // Updated format
                "Panacan, Davao City",
                "BSIT",
                "2nd Year",
                "john.rabosa@example.com");

        Student student2 = new Student(
                "2",
                "Erwin Curato",
                "20",
                "08/15/2004", // Updated format
                "Bajada, Davao City",
                "BSIT",
                "3rd Year",
                "erwin.curato@example.com");

        Student student3 = new Student(
                "3",
                "Mark Anthony Villanueva",
                "18",
                "05/20/2006", // Updated format
                "Toril, Davao City",
                "BSIT",
                "1st Year",
                "mark.villanueva@example.com");

        Student student4 = new Student(
                "4",
                "Anna Mae Castillo",
                "21",
                "09/02/2003", // Updated format
                "Matina, Davao City",
                "BSIT",
                "4th Year",
                "anna.castillo@example.com");

        Student student5 = new Student(
                "5",
                "Christian James Delos Santos",
                "19",
                "02/18/2005", // Updated format
                "Lanang, Davao City",
                "BSIT",
                "2nd Year",
                "christian.santos@example.com");

        Student student6 = new Student(
                "6",
                "Rochelle Mae Bautista",
                "20",
                "11/10/2004", // Updated format
                "Mintal, Davao City",
                "BSIT",
                "3rd Year",
                "rochelle.bautista@example.com");

        Student student7 = new Student(
                "7",
                "Joshua Emmanuel Cruz",
                "22",
                "07/25/2002", // Updated format
                "Sasa, Davao City",
                "BSIT",
                "4th Year",
                "joshua.cruz@example.com");

        StudentRepo.getStudents().add(student1);
        StudentRepo.getStudents().add(student2);
        StudentRepo.getStudents().add(student3);
        StudentRepo.getStudents().add(student4);
        StudentRepo.getStudents().add(student5);
        StudentRepo.getStudents().add(student6);
        StudentRepo.getStudents().add(student7);
    }
}