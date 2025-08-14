package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {

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
        if (StudentRepo.getStudents().isEmpty()) {
            createDummyStudent();
        }

        studentsTableView.setEditable(false);
        studentsTableView.setFocusTraversable(false);
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

    @FXML
    private void onSearchStudentAction() throws IOException {
        String queryId = searchTextField.getText().trim().toLowerCase();
        if (queryId.isEmpty()) {
            return;
        }

        Student foundStudent = null;
        for (Student s : StudentRepo.getStudents()) {
            if (s.getId().get().toLowerCase().contains(queryId)) {
                foundStudent = s;
                break;
            }
        }

        indicatorVboxContainer.getChildren().clear();

        if (foundStudent == null) {
            FXMLLoader nfLoader = new FXMLLoader(getClass().getResource("/com/school/studentmanagementfx/view/child/NotFound.fxml"));
            indicatorVboxContainer.getChildren().add(nfLoader.load());
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/school/studentmanagementfx/view/child/Found.fxml"));
        Node childNode = loader.load();
        FoundStudentController controller = loader.getController();

        Student target = foundStudent;
        controller.getViewStudentDetailButton().setOnAction(e ->
            StudentDetailsController.showStudentDetails(e, target)
        );

        indicatorVboxContainer.getChildren().add(childNode);
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) throws IOException {
        String addStudentFxml = "/com/school/studentmanagementfx/view/AddStudentView.fxml";
        CreateWindow.createModalWindow(event, addStudentFxml, "Add Student");
    }

    @FXML
    private void onLogOutAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    private void addDetailButton() {
        detailTableColumn.setCellFactory(col -> new TableCell<>() {
            private final Button viewButton = new Button("View");

            {
                viewButton.setOnAction(event -> {
                    Student student = getTableView().getItems().get(getIndex());
                    StudentDetailsController.showStudentDetails(event, student);
                });
                String buttonCss = "/com/school/studentmanagementfx/style/Button.css";
                viewButton.getStylesheets().add(Objects.requireNonNull(getClass().getResource(buttonCss)).toExternalForm());
                viewButton.setPadding(new Insets(4, 20, 4, 20));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : viewButton);
            }
        });
    }

    private void createDummyStudent() {
        Student student1 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student2 = new Student("2", "Erwin Curato", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student3 = new Student("3", "fucking shit", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student4 = new Student("4", "dummy", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student5 = new Student("5", "Idkawd", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        StudentRepo.getStudents().add(student1);
        StudentRepo.getStudents().add(student2);
        StudentRepo.getStudents().add(student3);
        StudentRepo.getStudents().add(student4);
        StudentRepo.getStudents().add(student5);
    }
}
