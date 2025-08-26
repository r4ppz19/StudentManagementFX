package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.util.StudentFormValidator;
import com.school.studentmanagementfx.util.UIComponentHelper;
import com.school.studentmanagementfx.view.StageManager;
import com.school.studentmanagementfx.view.ViewManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Map;

public class StudentDetailViewController {

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
    private Button editButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteButton;

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
                "email", emailTextField
        );

        errorLabels = Map.of(
                "id", idErrorLabel,
                "name", nameErrorLabel,
                "age", ageErrorLabel,
                "birthday", birthdayErrorLabel,
                "address", addressErrorLabel,
                "course", courseErrorLabel,
                "year", yearErrorLabel,
                "email", emailErrorLabel
        );
        setReadOnlyModeState();
        Platform.runLater(() -> closeButton.requestFocus());
    }

    @FXML
    private void onCancelAction() {
        setStudent(student);
        setReadOnlyModeState();
    }

    @FXML
    private void onEditAction() {
        setEditModeState();
    }

    @FXML
    private void onSaveAction(ActionEvent event) {
        if (StudentFormValidator.validateAndShowErrors(errorLabels, textFields)) {
            return;
        }

        if (hasChanges()) {
            Stage current = StageManager.getCurrentStage(event);
            if (ViewManager.showWarningViewTwo(current)) {
                updateStudentFromFields();
                StudentFileService.saveToDataBase();
                setReadOnlyModeState();
            }
        }
    }

    @FXML
    private void onDeleteAction(ActionEvent event) {
        Stage current = StageManager.getCurrentStage(event);
        if (ViewManager.showWarningViewOne(current)) {
            StudentRepo.getStudents().remove(student);
            StudentFileService.saveToDataBase();
            current.close();
        }
    }

    @FXML
    private void onCloseAction(ActionEvent event) {
        StageManager.getCurrentStage(event).close();
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

    private void setEditModeState() {
        UIComponentHelper.showButton(saveButton, true);
        UIComponentHelper.showButton(deleteButton, true);
        UIComponentHelper.showButton(cancelButton, true);
        UIComponentHelper.showButton(editButton, false);
        UIComponentHelper.showButton(closeButton, false);
        UIComponentHelper.setFieldsEditable(textFields, true);
    }

    private void setReadOnlyModeState() {
        UIComponentHelper.showButton(saveButton, false);
        UIComponentHelper.showButton(deleteButton, false);
        UIComponentHelper.showButton(cancelButton, false);
        UIComponentHelper.showButton(editButton, true);
        UIComponentHelper.showButton(closeButton, true);
        UIComponentHelper.setFieldsEditable(textFields, false);
    }

    private void updateStudentFromFields() {
        student.getId().set(idTextField.getText());
        student.getName().set(nameTextField.getText());
        student.getAge().set(ageTextField.getText());
        student.getBirthday().set(birthdayTextField.getText());
        student.getAddress().set(addressTextField.getText());
        student.getCourse().set(courseTextField.getText());
        student.getYear().set(yearTextField.getText());
        student.getEmail().set(emailTextField.getText());
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
