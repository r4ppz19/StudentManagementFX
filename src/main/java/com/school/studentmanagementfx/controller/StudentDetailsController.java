package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import com.school.studentmanagementfx.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDetailsController {
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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    public static void showStudentDetails(ActionEvent event, Student student) {
        try {
            Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            String fxmlPath = "/com/school/studentmanagementfx/view/StudentDetailsView.fxml";

            FXMLLoader loader = new FXMLLoader(CreateWindow.class.getResource(fxmlPath));
            Parent root = loader.load();

            StudentDetailsController studentDetailsController = loader.getController();
            studentDetailsController.setStudent(student);

            CreateWindow.createWindow(root, parentStage, "Student Details");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStudent(Student student) {
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
