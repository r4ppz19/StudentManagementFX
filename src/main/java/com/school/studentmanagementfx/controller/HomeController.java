package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import com.school.studentmanagementfx.helper.IconHelper;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
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
        logOutAction();
        studentsTableView.setFocusTraversable(false);
        studentsTableView.getColumns().forEach(col -> col.setResizable(false));
        studentsTableView.getColumns().forEach(col -> col.setReorderable(false));

        createDummyStudent();

        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        courseTableColumn.setCellValueFactory(cellData -> cellData.getValue().getCourse());
        yearTableColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        addMoreDetailButton();

        studentsTableView.setItems(StudentRepository.getStudents());
    }

    @FXML
    private void onSearchStudentAction() {
    }

    @FXML
    private void onAddStudentAction(ActionEvent event) throws IOException {
        String addStudentFxml = "/com/school/studentmanagementfx/view/AddStudentView.fxml";
        CreateWindow.createModalWindow(event, addStudentFxml);
    }

    private void logOutAction() {
        logOutLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }

    private void addMoreDetailButton() {
        moreDetailTableColumn.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("View");

            {
                btn.setOnAction(event -> {
                    Student student = getTableView().getItems().get(getIndex());

                    try {
                        FXMLLoader loader = new FXMLLoader(
                                getClass().getResource("/com/school/studentmanagementfx/view/StudentDetailsView.fxml")
                        );
                        Parent root = loader.load();

                        StudentDetailsController controller = loader.getController();
                        controller.setStudent(student);

                        Stage stage = new Stage();
                        IconHelper.setAppIcon(stage);
                        stage.setScene(new Scene(root));
                        stage.setTitle("Student Management");
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setFullScreen(false);
                        stage.setResizable(false);
                        stage.showAndWait();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                btn.getStylesheets().add(
                        Objects.requireNonNull(getClass().getResource("/com/school/studentmanagementfx/style/Button.css")).toExternalForm()
                );
                btn.setPadding(new Insets(4, 20, 4, 20));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }

    private void createDummyStudent() {
        Student student1 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student2 = new Student("1", "Erwin Curato", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student3 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student4 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        Student student5 = new Student("1", "John Rey Rabosa", "19", "12-31-2005", "Panacan Davao City", "BSIT", "2nd year", "johnreyrabosa.f@gmail.com");
        StudentRepository.getStudents().add(student1);
        StudentRepository.getStudents().add(student2);
        StudentRepository.getStudents().add(student3);
        StudentRepository.getStudents().add(student4);
        StudentRepository.getStudents().add(student5);
    }
}
