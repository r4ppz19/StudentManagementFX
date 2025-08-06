package com.school.studentmanagementfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {

    @FXML
    TextField idTextField;

    @FXML
    TextField nameTextField;

    @FXML
    TextField ageTextField;

    @FXML
    TextField birthdayTextField;

    @FXML
    TextField addressTextField;

    @FXML
    TextField courseTextField;

    @FXML
    TextField yearTextField;

    @FXML
    TextField emailTextField;

    @FXML
    private void cancelButton(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    private void addBtn() {

    }
}
