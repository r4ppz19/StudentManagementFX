package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;

import java.io.IOException;

import com.school.studentmanagementfx.helper.CreateWindow;
import com.school.studentmanagementfx.helper.IconHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController {
    @FXML
    private TextField searchTextField;

    @FXML
    private void searchBtn(ActionEvent event) throws IOException {
        String id = searchTextField.getText();

        if (id == null || id.trim().isEmpty()) {
            String errorViewFxml = "/com/school/studentmanagementfx/view/ErrorView.fxml";
            CreateWindow.createModalWindow(event, errorViewFxml);
        } else {
            id = id.trim();

            ObservableList<Student> result = FXCollections.observableArrayList();
            for (Student s : StudentRepository.getStudents()) {
                if (s.getId().get().equals(id)) {
                    result.add(s);
                    break;
                }
            }

            String resultViewFxml = "/com/school/studentmanagementfx/view/ResultView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resultViewFxml));
            Parent root = loader.load();
            ResultController controller = loader.getController();
            controller.setStudentList(result);

            Stage stage = new Stage();
            stage.setTitle("Student Management");
            stage.setScene(new Scene(root));
            IconHelper.setAppIcon(stage);
            stage.setResizable(false);
            stage.show();
        }
    }
}