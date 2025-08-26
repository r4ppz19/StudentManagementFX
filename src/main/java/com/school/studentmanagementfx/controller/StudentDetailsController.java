package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.view.ViewManager;
import com.school.studentmanagementfx.view.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private void onEditAction() {
        setFieldsEditable(true);
        saveButton.setDisable(false);
        editButton.setDisable(true);
    }

    @FXML
    private void onSaveStudentAction() {
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
    private void onDeleteStudentAction(ActionEvent event) {
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
}
