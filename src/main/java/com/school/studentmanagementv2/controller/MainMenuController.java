package com.school.studentmanagementv2.controller;

import com.school.studentmanagementv2.helper.CreateWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {
    private final String ADD_VIEW_FXML = "/com/school/studentmanagementv2/AddView.fxml";
    private final String DISPLAY_VIEW_FXML = "/com/school/studentmanagementv2/DisplayView.fxml";
    private final String SEARCH_VIEW_FXML = "/com/school/studentmanagementv2/SearchView.fxml";

    @FXML
    private void addStudentBtn(ActionEvent event) throws IOException {
        CreateWindow.createWindow(event, ADD_VIEW_FXML, "Add Student");
    }

    @FXML
    private void displayStudentBtn(ActionEvent event) throws IOException {
        CreateWindow.createWindow(event, DISPLAY_VIEW_FXML, "Display Students");
    }

    @FXML
    private void searchStudentBtn(ActionEvent event) throws IOException {
        CreateWindow.createWindow(event, SEARCH_VIEW_FXML, "Search Students");
    }

    @FXML
    private void exitBtn() {
        Platform.exit();
    }
}