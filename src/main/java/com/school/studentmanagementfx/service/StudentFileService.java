package com.school.studentmanagementfx.service;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;

import java.io.*;
import java.util.Arrays;

public class StudentFileService {
    private static final String FILE_PATH = "data/DataBase.txt";

    public static void saveToDataBase() {
        try {
            ensureFileExists();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Student student : StudentRepo.getStudents()) {
                    writer.write(formatStudent(student));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    public static void loadFromDataBase() {
        StudentRepo.getStudents().clear();
        try {
            ensureFileExists();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.isBlank()) {
                        Student student = parseStudentFromFile(line);
                        if (student != null) {
                            StudentRepo.getStudents().add(student);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
    }

    private static String formatStudent(Student student) {
        return String.join("|",
                student.getId().get(),
                student.getName().get(),
                student.getAge().get(),
                student.getBirthday().get(),
                student.getAddress().get(),
                student.getCourse().get(),
                student.getYear().get(),
                student.getEmail().get());
    }

    private static Student parseStudentFromFile(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 8) {
            System.out.println("Invalid data format: " + Arrays.toString(parts));
            return null;
        }
        return new Student(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7]);
    }

    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);

        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            if (!parent.mkdirs()) {
                throw new IOException("Failed to create directory: " + parent.getAbsolutePath());
            }
        }

        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file: " + file.getAbsolutePath());
            }
        }
    }
}