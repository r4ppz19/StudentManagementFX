package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResultController {

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

    private ObservableList<Student> providedList;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cd -> cd.getValue().getId());
        nameColumn.setCellValueFactory(cd -> cd.getValue().getName());
        ageColumn.setCellValueFactory(cd -> cd.getValue().getAge());
        birthdayColumn.setCellValueFactory(cd -> cd.getValue().getBirthday());
        addressColumn.setCellValueFactory(cd -> cd.getValue().getAddress());
        courseColumn.setCellValueFactory(cd -> cd.getValue().getCourse());
        yearColumn.setCellValueFactory(cd -> cd.getValue().getYear());
        emailColumn.setCellValueFactory(cd -> cd.getValue().getEmail());

        configureColumn(idColumn);
        configureColumn(nameColumn);
        configureColumn(ageColumn);
        configureColumn(birthdayColumn);
        configureColumn(addressColumn);
        configureColumn(courseColumn);
        configureColumn(yearColumn);
        configureColumn(emailColumn);

        // Show provided list or empty
        tableView.setItems(providedList != null ? providedList : FXCollections.observableArrayList());
    }

    public void setStudentList(ObservableList<Student> list) {
        this.providedList = list;
        if (tableView != null) {
            tableView.setItems(list);
        }
    }

    private void configureColumn(TableColumn<Student, String> column) {
        column.setReorderable(false);
        column.setSortable(false);
        column.setResizable(false);
    }
}