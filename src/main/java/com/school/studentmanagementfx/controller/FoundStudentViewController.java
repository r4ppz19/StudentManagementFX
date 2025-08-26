package com.school.studentmanagementfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FoundStudentViewController {

    @FXML
    private Button viewStudentDetailButton;
    @FXML
    private Label studentIdLabel;
    @FXML
    private Label studentNameLabel;

    public Button getViewStudentDetailButton() {
        return viewStudentDetailButton;
    }

    public void setStudentIdLabel(String id) {
        studentIdLabel.setText(id);
    }

    public void setStudentNameLabel(String name) {
        studentNameLabel.setText(name);
    }
}
