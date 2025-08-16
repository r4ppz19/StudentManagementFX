package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.WindowManager;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

    public static void showStudentDetails(ActionEvent event, Student student) {
        try {
            Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            String fxmlPath = "/com/school/studentmanagementfx/view/StudentDetailsView.fxml";

            FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(fxmlPath));
            Parent root = loader.load();

            StudentDetailsController controller = loader.getController();
            controller.setStudent(student);

            WindowManager.createWindow(root, parentStage, "Student Details");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void onCloseAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onDeleteStudentAction(ActionEvent event) {
        Stage parentStage = WindowManager.getCurrentStage(event);
        if (WarningController.showWarningWindow(parentStage)) {
            StudentRepo.getStudents().remove(student);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    private void setStudent(Student student) {
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
