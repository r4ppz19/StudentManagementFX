package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.util.StudentFormUtils;
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
    private Button editSaveButton;
    @FXML
    private Button closeDeleteButton;

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

        StudentFormUtils.setFieldsEditable(false, textFields);
    }

    @FXML
    private void onEditSaveAction(ActionEvent event) {
        if ("Edit".equals(editSaveButton.getText())) {
            StudentFormUtils.setFieldsEditable(true, textFields);
            editSaveButton.setText("Save");
            closeDeleteButton.setText("Delete");
        } else {
            if (StudentFormUtils.validateAndShowErrors(errorLabels, textFields)) {
                return;
            }

            if (hasChanges()) {
                Stage current = WindowManager.getCurrentStage(event);
                if (!ViewManager.showWarningViewTwo(current)) {
                    return;
                }
                updateStudentFromFields();
                StudentFileService.saveToDataBase();
            }

            StudentFormUtils.setFieldsEditable(false, textFields);
            editSaveButton.setText("Edit");
            closeDeleteButton.setText("Close");
        }
    }


    @FXML
    private void onCloseDeleteAction(ActionEvent event) {
        if ("Close".equals(closeDeleteButton.getText())) {
            WindowManager.getCurrentStage(event).close();
        } else {
            Stage owner = WindowManager.getCurrentStage(event);
            if (ViewManager.showWarningViewOne(owner)) {
                StudentRepo.getStudents().remove(student);
                StudentFileService.saveToDataBase();
                owner.close();
            }
        }
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
    }

    private void updateStudentFromFields() {
        student.getId().set(textFields.get("id").getText());
        student.getName().set(textFields.get("name").getText());
        student.getAge().set(textFields.get("age").getText());
        student.getBirthday().set(textFields.get("birthday").getText());
        student.getAddress().set(textFields.get("address").getText());
        student.getCourse().set(textFields.get("course").getText());
        student.getYear().set(textFields.get("year").getText());
        student.getEmail().set(textFields.get("email").getText());
    }

    private boolean hasChanges() {
        return !student.getId().get().equals(idTextField.getText()) ||
                !student.getName().get().equals(nameTextField.getText()) ||
                !student.getAge().get().equals(ageTextField.getText()) ||
                !student.getBirthday().get().equals(birthdayTextField.getText()) ||
                !student.getAddress().get().equals(addressTextField.getText()) ||
                !student.getCourse().get().equals(courseTextField.getText()) ||
                !student.getYear().get().equals(yearTextField.getText()) ||
                !student.getEmail().get().equals(emailTextField.getText());
    }
}
