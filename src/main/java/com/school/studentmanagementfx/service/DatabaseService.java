package com.school.studentmanagementfx.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.school.studentmanagementfx.model.DatabaseConnector;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;

public class DatabaseService {

    public static boolean addStudent(Student student) {
        String sql = "INSERT INTO student (id, name, age, birthday, address, course, year, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(sql)) {
            statement.setString(1, student.getId().get());
            statement.setString(2, student.getName().get());
            statement.setString(3, student.getAge().get());
            statement.setString(4, student.getBirthday().get());
            statement.setString(5, student.getAddress().get());
            statement.setString(6, student.getCourse().get());
            statement.setString(7, student.getYear().get());
            statement.setString(8, student.getEmail().get());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                StudentRepo.getStudents().add(student);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteStudent(String id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(sql)) {
            statement.setString(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                StudentRepo.getStudents().removeIf(s -> s.getId().get().equals(id));
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Student findStudentById(String id) {
        String sql = "SELECT * FROM student WHERE id = ?";

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(sql)) {
            statement.setString(1, id);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    return new Student(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("age"),
                            result.getString("birthday"),
                            result.getString("address"),
                            result.getString("course"),
                            result.getString("year"),
                            result.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateStudent(Student student) {
        String sql = "UPDATE student SET name = ?, age = ?, birthday = ?, address = ?, course = ?, year = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(sql)) {
            statement.setString(1, student.getName().get());
            statement.setString(2, student.getAge().get());
            statement.setString(3, student.getBirthday().get());
            statement.setString(4, student.getAddress().get());
            statement.setString(5, student.getCourse().get());
            statement.setString(6, student.getYear().get());
            statement.setString(7, student.getEmail().get());
            statement.setString(8, student.getId().get());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                StudentRepo.getStudents().removeIf(s -> s.getId().get().equals(student.getId().get()));
                StudentRepo.getStudents().add(student);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void loadAllStudents() {
        String sql = "SELECT id, name, age, birthday, address, course, year, email FROM student";

        try (Statement statement = DatabaseConnector.getConnection().createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            StudentRepo.getStudents().clear();

            while (result.next()) {
                Student student = new Student(
                        result.getString("id"),
                        result.getString("name"),
                        result.getString("age"),
                        result.getString("birthday"),
                        result.getString("address"),
                        result.getString("course"),
                        result.getString("year"),
                        result.getString("email"));
                StudentRepo.getStudents().add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
