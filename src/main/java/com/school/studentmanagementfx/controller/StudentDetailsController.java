package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.view.ViewManager;
import com.school.studentmanagementfx.view.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private void onCloseAction(ActionEvent event) {
        WindowManager.getCurrentStage(event).close();
    }

    @FXML
    private void onDeleteStudentAction(ActionEvent event) {
        Stage owner = WindowManager.getCurrentStage(event);
        if (ViewManager.showWarningView(owner)) {
            StudentRepo.getStudents().remove(student);
            StudentFileService.saveToDataBase();
            WindowManager.getCurrentStage(event).close();
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
}
