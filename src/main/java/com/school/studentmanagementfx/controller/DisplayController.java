package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.ConfigureTable;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DisplayController {

    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> ageColumn;
    @FXML
    private TableColumn<Student, String> birthdayColumn;
    @FXML
    private TableColumn<Student, String> addressColumn;
    @FXML
    private TableColumn<Student, String> courseColumn;
    @FXML
    private TableColumn<Student, String> yearColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    public void initialize() {
        ConfigureTable.configureTableColumns(idColumn, nameColumn, ageColumn, birthdayColumn, addressColumn,
                courseColumn, yearColumn, emailColumn);
        tableView.setItems(StudentRepository.getStudents());
    }
}
