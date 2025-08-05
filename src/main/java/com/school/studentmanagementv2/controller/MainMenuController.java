package com.school.studentmanagementv2.controller;

import com.school.studentmanagementv2.helper.CreateWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private void addStudentBtn(ActionEvent event) throws IOException {
        CreateWindow.createWindow(event, "/com/school/studentmanagementv2/AddView.fxml", "Add Student");
    }

    @FXML
    private void displayStudentBtn(ActionEvent event) throws IOException {
        CreateWindow.createWindow(event, "/com/school/studentmanagementv2/DisplayView.fxml", "Display Student");

    }

    @FXML
    private void searchStudentBtn(ActionEvent event) throws IOException {
        CreateWindow.createWindow(event, "/com/school/studentmanagementv2/SearchView.fxml", "Search Student");

    }

    @FXML
    private void exitBtn() {
        Platform.exit();
    }
}
