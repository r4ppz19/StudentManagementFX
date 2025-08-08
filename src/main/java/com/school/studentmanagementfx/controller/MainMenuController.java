package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private void addStudentBtn(ActionEvent event) throws IOException {
        String ADD_VIEW_FXML = "/com/school/studentmanagementfx/view/AddView.fxml";
        CreateWindow.createWindow(event, ADD_VIEW_FXML);
    }

    @FXML
    private void displayStudentBtn(ActionEvent event) throws IOException {
        String DISPLAY_VIEW_FXML = "/com/school/studentmanagementfx/view/DisplayView.fxml";
        CreateWindow.createWindow(event, DISPLAY_VIEW_FXML);
    }

    @FXML
    private void searchStudentBtn(ActionEvent event) throws IOException {
        String SEARCH_VIEW_FXML = "/com/school/studentmanagementfx/view/SearchView.fxml";
        CreateWindow.createWindow(event, SEARCH_VIEW_FXML);
    }
}