package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private void addStudentBtn(ActionEvent event) throws IOException {
        String addViewFxml = "/com/school/studentmanagementfx/view/AddView.fxml";
        CreateWindow.createWindow(event, addViewFxml);
    }

    @FXML
    private void displayStudentBtn(ActionEvent event) throws IOException {
        String displayViewFxml = "/com/school/studentmanagementfx/view/DisplayView.fxml";
        CreateWindow.createWindow(event, displayViewFxml);
    }

    @FXML
    private void searchStudentBtn(ActionEvent event) throws IOException {
        String searchViewFxml = "/com/school/studentmanagementfx/view/SearchView.fxml";
        CreateWindow.createWindow(event, searchViewFxml);
    }
}