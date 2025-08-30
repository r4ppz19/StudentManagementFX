package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.service.StudentService;
import com.school.studentmanagementfx.util.UIComponentHelper;
import com.school.studentmanagementfx.view.StageManager;
import com.school.studentmanagementfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeViewController {

    @FXML
    private TextField searchTextField;
    @FXML
    private TableView<Student> studentsTableView;
    @FXML
    private TableColumn<Student, String> idTableColumn;
    @FXML
    private TableColumn<Student, String> nameTableColumn;
    @FXML
    private TableColumn<Student, String> courseTableColumn;
    @FXML
    private TableColumn<Student, String> yearTableColumn;
    @FXML
    private TableColumn<Student, Void> detailTableColumn;
    @FXML
    private VBox indicatorVboxContainer;

    @FXML
    private void initialize() {
        StudentService.loadAllStudents();
        UIComponentHelper.configureTable(
                studentsTableView,
                idTableColumn,
                nameTableColumn,
                courseTableColumn,
                yearTableColumn,
                detailTableColumn);
    }

    @FXML
    private void onSearchStudentAction() {
        indicatorVboxContainer.getChildren().clear();

        String queryId = searchTextField.getText().trim();
        if (queryId.isEmpty()) {
            return;
        }

        Student foundStudent = StudentService.findStudentById(queryId);

        if (foundStudent == null) {
            ViewManager.showNotFoundChild(indicatorVboxContainer);
        } else {
            ViewManager.showFoundChild(indicatorVboxContainer, foundStudent);
        }
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) {
        Stage stage = StageManager.getCurrentStage(event);
        ViewManager.showAddStudentView(stage);
    }

    @FXML
    private void onLogOutAction(ActionEvent event) {
        Stage current = StageManager.getCurrentStage(event);
        ViewManager.showLoginView(current);
    }
}
