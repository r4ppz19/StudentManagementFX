package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {

    @FXML
    private TextField searchTextField;

    @FXML
    private Label logOutLabel;

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
    private TableColumn<Student, Void> moreDetailTableColumn;

    @FXML
    private void initialize() {
        createDummyStudent();
        logOutAction();

        studentsTableView.setEditable(false);
        studentsTableView.setFocusTraversable(false);
        studentsTableView.getColumns().forEach(col -> col.setResizable(false));
        studentsTableView.getColumns().forEach(col -> col.setReorderable(false));

        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        courseTableColumn.setCellValueFactory(cellData -> cellData.getValue().getCourse());
        yearTableColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        addDetailButton();

        studentsTableView.setItems(StudentRepo.getStudents());
    }

    @FXML
    private void onSearchStudentAction() {
        String queryId = searchTextField.getText().trim().toLowerCase();
        ObservableList<Student> filtered = FXCollections.observableArrayList();
        for (Student s : StudentRepo.getStudents()) {
            if (s.getId().get().toLowerCase().contains(queryId)) {
                filtered.add(s);
                System.out.println("Student found: " + s.getName());
            }
        }
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) throws IOException {
        String addStudentFxml = "/com/school/studentmanagementfx/view/AddStudentView.fxml";
        CreateWindow.createModalWindow(event, addStudentFxml, "Add Student");
    }

    private void logOutAction() {
        logOutLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }

    private void addDetailButton() {
        moreDetailTableColumn.setCellFactory(col -> new TableCell<>() {
            private final Button viewButton = new Button("View");

            {
                viewButton.setOnAction(event -> {
                    Student student = getTableView().getItems().get(getIndex());
                    CreateWindow.showStudentDetails(student);
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
        Student student2 = new Student("1", "Erwin Curato", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student3 = new Student("1", "fucking shit", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student4 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student5 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        StudentRepo.getStudents().add(student1);
        StudentRepo.getStudents().add(student2);
        StudentRepo.getStudents().add(student3);
        StudentRepo.getStudents().add(student4);
        StudentRepo.getStudents().add(student5);
    }
}
