package com.school.studentmanagementfx.helper;

import com.school.studentmanagementfx.model.Student;
import javafx.scene.control.TableColumn;

public class ConfigureTable {
    public static void configureTableColumns(TableColumn<Student, String> idColumn,
            TableColumn<Student, String> nameColumn, TableColumn<Student, String> ageColumn,
            TableColumn<Student, String> birthdayColumn, TableColumn<Student, String> addressColumn,
            TableColumn<Student, String> courseColumn, TableColumn<Student, String> yearColumn,
            TableColumn<Student, String> emailColumn) {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().getAge());
        birthdayColumn.setCellValueFactory(cellData -> cellData.getValue().getBirthday());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().getCourse());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmail());

        configureColumn(idColumn);
        configureColumn(nameColumn);
        configureColumn(ageColumn);
        configureColumn(birthdayColumn);
        configureColumn(addressColumn);
        configureColumn(courseColumn);
        configureColumn(yearColumn);
        configureColumn(emailColumn);
    }

    private static void configureColumn(TableColumn<Student, String> column) {
        column.setReorderable(false);
        column.setSortable(false);
        column.setResizable(true);
    }
}
