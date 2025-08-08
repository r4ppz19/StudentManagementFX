package com.school.studentmanagementfx.controller;

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
        tableView.setEditable(false);

        configureColumn(idColumn);
        configureColumn(nameColumn);
        configureColumn(ageColumn);
        configureColumn(birthdayColumn);
        configureColumn(addressColumn);
        configureColumn(courseColumn);
        configureColumn(yearColumn);
        configureColumn(emailColumn);

        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().getAge());
        birthdayColumn.setCellValueFactory(cellData -> cellData.getValue().getBirthday());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().getCourse());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmail());

        tableView.setItems(StudentRepository.getStudents());
    }

    private void configureColumn(TableColumn<Student, String> column) {
        column.setReorderable(false);
        column.setSortable(false);
        column.setResizable(false);
    }
}
