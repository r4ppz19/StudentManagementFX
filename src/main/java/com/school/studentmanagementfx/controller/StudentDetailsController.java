package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.service.AddStudentValidator;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.view.ViewManager;
import com.school.studentmanagementfx.view.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Map;

public class StudentDetailsController {

    private Student student;

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
    private Button saveButton;
    @FXML
    private Button editButton;

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
    private void onEditAction() {
        setFieldsEditable(true);
        saveButton.setDisable(false);
        editButton.setDisable(true);
    }

    @FXML
    private void onSaveAction() {
        clearErrorLabels();

        // Validate fields
        Map<String, String> errors = AddStudentValidator.validateFields(
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
            return;
        }

        student.getId().set(idTextField.getText());
        student.getName().set(nameTextField.getText());
        student.getAge().set(ageTextField.getText());
        student.getBirthday().set(birthdayTextField.getText());
        student.getAddress().set(addressTextField.getText());
        student.getCourse().set(courseTextField.getText());
        student.getYear().set(yearTextField.getText());
        student.getEmail().set(emailTextField.getText());

        StudentFileService.saveToDataBase();

        setFieldsEditable(false);
        saveButton.setDisable(true);
        editButton.setDisable(false);
    }

    @FXML
    private void onDeleteAction(ActionEvent event) {
        Stage owner = WindowManager.getCurrentStage(event);
        if (ViewManager.showWarningView(owner)) {
            StudentRepo.getStudents().remove(student);
            StudentFileService.saveToDataBase();
            owner.close();
        }
    }

    private void setFieldsEditable(boolean editable) {
        idTextField.setEditable(editable);
        nameTextField.setEditable(editable);
        ageTextField.setEditable(editable);
        birthdayTextField.setEditable(editable);
        addressTextField.setEditable(editable);
        courseTextField.setEditable(editable);
        yearTextField.setEditable(editable);
        emailTextField.setEditable(editable);
    }

    public void setStudent(Student student) {
        this.student = student;
        idTextField.setText(student.getId().get());
        nameTextField.setText(student.getName().get());
        ageTextField.setText(student.getAge().get());
        birthdayTextField.setText(student.getBirthday().get());
        addressTextField.setText(student.getAddress().get());
        courseTextField.setText(student.getCourse().get());
        yearTextField.setText(student.getYear().get());
        emailTextField.setText(student.getEmail().get());
        setFieldsEditable(false);
        saveButton.setDisable(true);
        editButton.setDisable(false);
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