package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.view.ViewManager;
import com.school.studentmanagementfx.view.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

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
        StudentFileService.loadFromDataBase();
        StudentRepo.createDummyStudent();
        StudentFileService.saveToDataBase();
        configureTable();
    }

    @FXML
    private void onSearchStudentAction() {
        indicatorVboxContainer.getChildren().clear();

        String queryId = searchTextField.getText().trim();
        if (queryId.isEmpty()) {
            return;
        }

        Student foundStudent = null;
        for (Student s : StudentRepo.getStudents()) {
            if (s.getId().get().equals(queryId)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            ViewManager.showNotFoundChild(indicatorVboxContainer);
            return;
        }

        ViewManager.showFoundChild(indicatorVboxContainer, foundStudent);
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) {
        Stage stage = WindowManager.getCurrentStage(event);
        ViewManager.showAddStudentView(stage);
    }

    @FXML
    private void onLogOutAction(ActionEvent event) {
        StudentFileService.saveToDataBase();
        Stage current = WindowManager.getCurrentStage(event);
        ViewManager.showLoginView(current);
    }

    private void configureTable() {
        studentsTableView.getColumns().forEach(col -> {
            col.setResizable(false);
            col.setReorderable(false);
            col.setSortable(false);
        });
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        courseTableColumn.setCellValueFactory(cellData -> cellData.getValue().getCourse());
        yearTableColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        addDetailButton();
        studentsTableView.setItems(StudentRepo.getStudents());
    }

    private void addDetailButton() {
        detailTableColumn.setCellFactory(col -> new TableCell<>() {
            private final Button viewButton = new Button("View");

            {
                viewButton.setOnAction(event -> {
                    Student student = studentsTableView.getItems().get(getIndex());
                    ViewManager.showStudentDetailView(event, student);
                });
                String buttonCss = "/com/school/studentmanagementfx/style/ViewButton.css";
                viewButton
                        .getStylesheets()
                        .add(
                                Objects.requireNonNull(
                                        getClass().getResource(buttonCss)).toExternalForm());
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : viewButton);
            }
        });
    }
}
