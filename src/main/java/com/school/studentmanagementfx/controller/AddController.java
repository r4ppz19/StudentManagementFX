package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddController {
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextArea addressTextField;
    @FXML
    private TextField courseTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField emailTextField;

    @FXML
    private void addBtn(ActionEvent event) throws IOException {
        StudentRepository.getStudents().add(getInfo(event));
        clearFields();
    }

    private Student getInfo(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String course = courseTextField.getText();
        String email = emailTextField.getText();
        String birthday = birthdayTextField.getText();
        String age = ageTextField.getText();
        String year = yearTextField.getText();
        String id = idTextField.getText();

        if (isNullOrEmpty(name) && isNullOrEmpty(address) && isNullOrEmpty(course) && isNullOrEmpty(email)
                && isNullOrEmpty(birthday) && isNullOrEmpty(age) && isNullOrEmpty(year) && isNullOrEmpty(id)) {
            String errorViewFxml = "/com/school/studentmanagementfx/view/ErrorView.fxml";
            CreateWindow.createModalWindow(event, errorViewFxml);
        }

        return new Student(
                id.trim(),
                name.trim(),
                age.trim(),
                birthday.trim(),
                address.trim(),
                course.trim(),
                year.trim(),
                email.trim());
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
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
