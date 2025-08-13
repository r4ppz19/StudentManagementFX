package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    private void onCancelAction() {

    }

    @FXML
    private void onAddStudentAction() {
        getStudentFromFields();
    }

    private Student getStudentFromFields() {
        return new Student(
                idTextField.getText().trim(),
                nameTextField.getText().trim(),
                ageTextField.getText().trim(),
                birthdayTextField.getText().trim(),
                addressTextField.getText().trim(),
                courseTextField.getText().trim(),
                yearTextField.getText().trim(),
                emailTextField.getText().trim()
        );
    }

}
