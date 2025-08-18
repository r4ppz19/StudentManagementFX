package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.util.StudentValidator;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.view.ViewManager;
import com.school.studentmanagementfx.view.WindowManager;
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

    // Error labels for inline validation
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

    @FXML
    private void onCancelAction(ActionEvent event) {
        WindowManager.getCurrentStage(event).close();
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) {
        clearErrorLabels();
        if (idTextField.getText().isEmpty() ||
                nameTextField.getText().isEmpty() ||
                ageTextField.getText().isEmpty() ||
                birthdayTextField.getText().isEmpty() ||
                addressTextField.getText().isEmpty() ||
                courseTextField.getText().isEmpty() ||
                yearTextField.getText().isEmpty() ||
                emailTextField.getText().isEmpty()) {

            ViewManager.showErrorViewOne(event);
            return;
        }
        // Validate fields using StudentValidator
        Map<String, String> errors = StudentValidator.validateFields(
                idTextField.getText(),
                nameTextField.getText(),
                ageTextField.getText(),
                birthdayTextField.getText(),
                addressTextField.getText(),
                courseTextField.getText(),
                yearTextField.getText(),
                emailTextField.getText());
        if (!errors.isEmpty()) {
            showErrors(errors);
            return; // Stop if validation fails
        }
        // Validation passed → add student
        StudentRepo.getStudents().add(getStudentFromFields());
        StudentFileService.saveToDataBase();
        ViewManager.showSuccessWindowOne(event);
        clearFields();

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

    private void clearErrorLabels() {
        idErrorLabel.setText("");
        nameErrorLabel.setText("");
        ageErrorLabel.setText("");
        birthdayErrorLabel.setText("");
        addressErrorLabel.setText("");
        courseErrorLabel.setText("");
        yearErrorLabel.setText("");
        emailErrorLabel.setText("");
    }

    private void showErrors(Map<String, String> errors) {
        if (errors.containsKey("id"))
            idErrorLabel.setText(errors.get("id"));
        if (errors.containsKey("name"))
            nameErrorLabel.setText(errors.get("name"));
        if (errors.containsKey("age"))
            ageErrorLabel.setText(errors.get("age"));
        if (errors.containsKey("birthday"))
            birthdayErrorLabel.setText(errors.get("birthday"));
        if (errors.containsKey("address"))
            addressErrorLabel.setText(errors.get("address"));
        if (errors.containsKey("course"))
            courseErrorLabel.setText(errors.get("course"));
        if (errors.containsKey("year"))
            yearErrorLabel.setText(errors.get("year"));
        if (errors.containsKey("email"))
            emailErrorLabel.setText(errors.get("email"));
    }
}