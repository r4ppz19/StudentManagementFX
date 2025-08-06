package com.school.studentmanagementv2.controller;

import com.school.studentmanagementv2.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DisplayController {
    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Number> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Number> ageColumn;

    @FXML
    private TableColumn<Student, String> birthdayColumn;

    @FXML
    private TableColumn<Student, String> addressColumn;

    @FXML
    private TableColumn<Student, String> courseColumn;

    @FXML
    private TableColumn<Student, Number> yearColumn;

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

        ObservableList<Student> students = FXCollections.observableArrayList(
                new Student(1, "Alice", 20, "2004-01-01", "123 St", "Math", 2, "alice@email.com"),
                new Student(2, "Bob", 21, "2003-02-02", "456 Ave", "Science", 3, "bob@email.com"),
                new Student(3, "Charlie", 19, "2005-03-15", "789 Oak Rd", "Computer Science", 1, "charlie@email.com"),
                new Student(4, "Diana", 22, "2002-07-20", "321 Pine Ln", "Engineering", 4, "diana@email.com"),
                new Student(5, "Emma", 20, "2004-09-10", "654 Elm St", "Biology", 2, "emma@email.com"),
                new Student(6, "Frank", 23, "2001-12-05", "987 Maple Ave", "Physics", 4, "frank@email.com"),
                new Student(7, "Grace", 18, "2006-04-25", "147 Cedar Dr", "Chemistry", 1, "grace@email.com"));

        tableView.setItems(students);
    }

    private void configureColumn(TableColumn<Student, ?> column) {
        column.setReorderable(false);
        column.setSortable(false);
        column.setResizable(false);
    }
}
