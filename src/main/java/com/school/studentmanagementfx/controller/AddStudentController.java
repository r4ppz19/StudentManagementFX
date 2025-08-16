package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.WindowManager;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

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
    private void onCancelAction(ActionEvent event) {
        WindowManager.getCurrentStage(event).close();
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) throws IOException {
        if (idTextField.getText().isEmpty() ||
                nameTextField.getText().isEmpty() ||
                ageTextField.getText().isEmpty() ||
                birthdayTextField.getText().isEmpty() ||
                addressTextField.getText().isEmpty() ||
                courseTextField.getText().isEmpty() ||
                yearTextField.getText().isEmpty() ||
                emailTextField.getText().isEmpty()) {

            String errorViewFxml = "/com/school/studentmanagementfx/view/alert/ErrorEmptyField.fxml";
            WindowManager.createModalWindow(event, errorViewFxml, "Error");
        } else {
            StudentRepo.getStudents().add(getStudentFromFields());
            String successViewFxml = "/com/school/studentmanagementfx/view/alert/SuccessStudentAdd.fxml";
            WindowManager.createModalWindow(event, successViewFxml, "Success");
            clearFields();
        }
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
                emailTextField.getText().trim());
    }

    private void clearFields() {
        idTextField.clear();
        nameTextField.clear();
        ageTextField.clear();
        birthdayTextField.clear();
        addressTextField.clear();
        courseTextField.clear();
        yearTextField.clear();
        emailTextField.clear();
    }
}
