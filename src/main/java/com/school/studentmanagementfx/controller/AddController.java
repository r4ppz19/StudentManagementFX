package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;
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
        StudentRepository.getStudents().add(getInfo());
        clearFields();
    }

    private Student getInfo() {
        String name = nameTextField.getText().trim();
        String address = addressTextField.getText().trim();
        String course = courseTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String birthday = birthdayTextField.getText().trim();
        String age = ageTextField.getText().trim();
        String year = yearTextField.getText().trim();
        String id = idTextField.getText().trim();

        return new Student(id, name, age, birthday, address, course, year, email);
    }

    private void clearFields() {
        idTextField.clear();
        ageTextField.clear();
        nameTextField.clear();
        addressTextField.clear();
        courseTextField.clear();
        emailTextField.clear();
        yearTextField.clear();
        birthdayTextField.clear();
    }
}
