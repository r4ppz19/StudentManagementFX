package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    public void addBtn() {
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
