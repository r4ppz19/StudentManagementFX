package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.model.StudentRepo;
import com.school.studentmanagementfx.view.ViewManager;
import javafx.scene.control.*;

import java.util.Map;
import java.util.Objects;

public class UIHelper {

    public static Student getStudentFromFields(Map<String, TextField> textFields) {
        return new Student(
                textFields.get("id").getText().trim(),
                textFields.get("name").getText().trim(),
                textFields.get("age").getText().trim(),
                textFields.get("birthday").getText().trim(),
                textFields.get("address").getText().trim(),
                textFields.get("course").getText().trim(),
                textFields.get("year").getText().trim(),
                textFields.get("email").getText().trim());
    }

    public static void setFieldsEditable(Map<String, TextField> textFields, boolean editable) {
        textFields.values().forEach((field) -> field.setEditable(editable));
    }

    public static void showButton(Button button, boolean visible) {
        button.setVisible(visible);
        button.setManaged(visible);
    }

    public static void clearFields(Map<String, TextField> textFields) {
        textFields.values().forEach(TextField::clear);
    }

    public static void configureTable(
            TableView<Student> studentsTableView,
            TableColumn<Student, String> idTableColumn,
            TableColumn<Student, String> nameTableColumn,
            TableColumn<Student, String> courseTableColumn,
            TableColumn<Student, String> yearTableColumn,
            TableColumn<Student, Void> detailTableColumn) {

        studentsTableView.getColumns().forEach(col -> {
            col.setResizable(false);
            col.setReorderable(false);
            col.setSortable(false);
        });
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        courseTableColumn.setCellValueFactory(cellData -> cellData.getValue().getCourse());
        yearTableColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        configureDetailTableColumn(detailTableColumn);
        studentsTableView.setItems(StudentRepo.getStudents());
    }

    private static void configureDetailTableColumn(TableColumn<Student, Void> detailTableColumn) {
        detailTableColumn.setCellFactory(col -> new TableCell<>() {
            private final Button viewButton = new Button("View");
            {
                viewButton.setOnAction(event -> {
                    Student student = getTableView().getItems().get(getIndex());
                    ViewManager.showStudentDetailView(event, student);
                });
                String buttonCss = "/com/school/studentmanagementfx/style/ViewButton.css";
                viewButton.getStylesheets().add(
                        Objects.requireNonNull(getClass().getResource(buttonCss)).toExternalForm());
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : viewButton);
            }
        });
    }
}
