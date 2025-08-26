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

    private Student currentStudent;

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
    private void onCancelAction(ActionEvent event) {
        Stage current = StageManager.getCurrentStage(event);
        if (hasChanges()) {
            if (!ViewManager.showWarningCancelView(current)) {
                return;
            }
        }
        setStudent(currentStudent);
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
            if (ViewManager.showWarningSaveView(current)) {
                updateStudentFromFields();
                StudentFileService.saveToDataBase();
                setReadOnlyModeState();
            }
        }
    }

    @FXML
    private void onDeleteAction(ActionEvent event) {
        Stage current = StageManager.getCurrentStage(event);
        if (ViewManager.showWarningDeleteView(current)) {
            StudentRepo.getStudents().remove(currentStudent);
            StudentFileService.saveToDataBase();
            current.close();
        }
    }

    @FXML
    private void onCloseAction(ActionEvent event) {
        StageManager.getCurrentStage(event).close();
    }

    public void setStudent(Student student) {
        this.currentStudent = student;
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
        currentStudent.getId().set(idTextField.getText());
        currentStudent.getName().set(nameTextField.getText());
        currentStudent.getAge().set(ageTextField.getText());
        currentStudent.getBirthday().set(birthdayTextField.getText());
        currentStudent.getAddress().set(addressTextField.getText());
        currentStudent.getCourse().set(courseTextField.getText());
        currentStudent.getYear().set(yearTextField.getText());
        currentStudent.getEmail().set(emailTextField.getText());
    }

    private boolean hasChanges() {
        return !currentStudent.getId().get().equals(idTextField.getText()) ||
                !currentStudent.getName().get().equals(nameTextField.getText()) ||
                !currentStudent.getAge().get().equals(ageTextField.getText()) ||
                !currentStudent.getBirthday().get().equals(birthdayTextField.getText()) ||
                !currentStudent.getAddress().get().equals(addressTextField.getText()) ||
                !currentStudent.getCourse().get().equals(courseTextField.getText()) ||
                !currentStudent.getYear().get().equals(yearTextField.getText()) ||
                !currentStudent.getEmail().get().equals(emailTextField.getText());
    }
}
