package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.service.DatabaseService;
import com.school.studentmanagementfx.util.StudentFormUtil;
import com.school.studentmanagementfx.util.UIHelper;
import com.school.studentmanagementfx.view.StageManager;
import com.school.studentmanagementfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Map;

public class AddStudentController {
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField courseTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField emailTextField;

    @FXML
    private Label idErrorLabel;
    @FXML
    private Label nameErrorLabel;
    @FXML
    private Label ageErrorLabel;
    @FXML
    private Label birthdayErrorLabel;
    @FXML
    private Label addressErrorLabel;
    @FXML
    private Label courseErrorLabel;
    @FXML
    private Label yearErrorLabel;
    @FXML
    private Label emailErrorLabel;

    private Map<String, Label> errorLabels;
    private Map<String, TextField> textFields;

    @FXML
    private void initialize() {
        textFields = Map.of(
                "id", idTextField,
                "name", nameTextField,
                "age", ageTextField,
                "birthday", birthdayTextField,
                "address", addressTextField,
                "course", courseTextField,
                "year", yearTextField,
                "email", emailTextField);

        errorLabels = Map.of(
                "id", idErrorLabel,
                "name", nameErrorLabel,
                "age", ageErrorLabel,
                "birthday", birthdayErrorLabel,
                "address", addressErrorLabel,
                "course", courseErrorLabel,
                "year", yearErrorLabel,
                "email", emailErrorLabel);
    }

    @FXML
    private void onCancelAction(ActionEvent event) {
        StageManager.getCurrentStage(event).close();
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) {
        if (StudentFormUtil.validateAndShowFieldErrors(errorLabels, textFields)) {
            return;
        }
        if (StudentFormUtil.showIdUniquenessErrorIfDuplicate(errorLabels, textFields)) {
            return;
        }
        if (DatabaseService.addStudent(UIHelper.getStudentFromFields(textFields))) {
            ViewManager.showSuccessStudentAddView(event);
            UIHelper.clearFields(textFields);
        }
    }
}