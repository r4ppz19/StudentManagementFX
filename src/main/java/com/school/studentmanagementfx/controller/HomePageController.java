package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HomePageController {

    @FXML
    private TextField searchTextField;

    @FXML
    private void onSearchStudentAction() {

    }

    @FXML
    private void onAddStudentAction(ActionEvent  event) throws IOException {
        String addStudentFxml = "/com/school/studentmanagementfx/view/AddStudentView.fxml";
        CreateWindow.createModalWindow(event, addStudentFxml);
    }
}
