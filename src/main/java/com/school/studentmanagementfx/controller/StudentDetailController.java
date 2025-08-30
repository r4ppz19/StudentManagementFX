package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.service.DatabaseService;
import com.school.studentmanagementfx.util.StudentFormUtil;
import com.school.studentmanagementfx.util.UIHelper;
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

public class StudentDetailController {

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
    private Label headerLabel;

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
        StudentFormUtil.clearErrorLabels(errorLabels);
        setReadOnlyModeState();
    }

    @FXML
    private void onEditAction() {
        setEditModeState();
    }

    @FXML
    private void onSaveAction(ActionEvent event) {
        if (StudentFormUtil.validateFieldsAndShowErrors(errorLabels, textFields)) {
            return;
        }

        if (hasChanges()) {
            Stage current = StageManager.getCurrentStage(event);
            if (ViewManager.showWarningSaveView(current)) {
                Student student = UIHelper.getStudentFromFields(textFields);
                DatabaseService.updateStudent(student);
                setReadOnlyModeState();
            }
        }
    }

    @FXML
    private void onDeleteAction(ActionEvent event) {
        Stage current = StageManager.getCurrentStage(event);
        if (ViewManager.showWarningDeleteView(current)) {
            String id = idTextField.getText();
            DatabaseService.deleteStudent(id);
            current.close();
        }
    }

    @FXML
    private void onCloseAction(ActionEvent event) {
        StageManager.getCurrentStage(event).close();
    }

    // The only public setter method to set and pass student object
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

    private void setEditModeState() {
        headerLabel.setText("Student Details  (Edit Mode)");
        UIHelper.showButton(saveButton, true);
        UIHelper.showButton(deleteButton, true);
        UIHelper.showButton(cancelButton, true);
        UIHelper.showButton(editButton, false);
        UIHelper.showButton(closeButton, false);
        UIHelper.setFieldsEditable(textFields, true);
    }

    private void setReadOnlyModeState() {
        headerLabel.setText("Student Details");
        UIHelper.showButton(saveButton, false);
        UIHelper.showButton(deleteButton, false);
        UIHelper.showButton(cancelButton, false);
        UIHelper.showButton(editButton, true);
        UIHelper.showButton(closeButton, true);
        UIHelper.setFieldsEditable(textFields, false);
    }
}
