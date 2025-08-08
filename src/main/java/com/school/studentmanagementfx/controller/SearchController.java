package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;

import java.io.IOException;

import com.school.studentmanagementfx.helper.IconHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public void searchBtn() throws IOException {
        String id = searchTextField != null ? searchTextField.getText() : null;
        if (id == null)
            id = "";
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
        stage.setTitle("Search Result");
        stage.setScene(new Scene(root));
        IconHelper.setAppIcon(stage);
        stage.setResizable(false);
        stage.show();
    }
}