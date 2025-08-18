package com.school.studentmanagementfx.service;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;

import java.io.*;

public class StudentFileService {
    private static final String FILE_PATH = "data/DataBase.txt";

    public static void saveToDataBase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : StudentRepo.getStudents()) {
                writer.write(formatStudent(student));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadFromDataBase() {
        StudentRepo.getStudents().clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StudentRepo.getStudents().add(parseStudentFromFile(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String formatStudent(Student student) {
        return String.join(",", student.getId().get(), student.getName().get(), student.getAge().get(),
                student.getBirthday().get(), student.getAddress().get(), student.getCourse().get(),
                student.getYear().get(),
                student.getEmail().get());
    }

    private static Student parseStudentFromFile(String line) {
        String[] parts = line.split(",");
        return new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
    }
}
