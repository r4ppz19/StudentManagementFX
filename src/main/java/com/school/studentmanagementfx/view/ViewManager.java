package com.school.studentmanagementfx.view;

import com.school.studentmanagementfx.controller.*;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.util.IconSetter;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewManager {

    public static void showLoginView(Stage stage) {
        String fxmlPath = "/com/school/studentmanagementfx/view/LoginView.fxml";
        LoadedView<LoginViewController> view = StageManager.loadView(fxmlPath);
        Scene scene = new Scene(view.getRoot());
        IconSetter.setAppIcon(stage);
        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void showHomeView(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/HomeView.fxml";
        LoadedView<HomeViewController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Student Management", false).show();
        current.close();
    }

    public static void showStudentDetailView(Event event, Student student) {
        String fxmlPath = "/com/school/studentmanagementfx/view/modal/StudentDetail.fxml";
        LoadedView<StudentDetailViewController> view = StageManager.loadView(fxmlPath);
        view.getController().setStudent(student);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Student Detail", true).showAndWait();
    }

    public static boolean showWarningViewOne(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningDelete.fxml";
        LoadedView<WarningViewController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), owner, "Warning", true).showAndWait();
        return view.getController().isConfirmed();
    }

    public static boolean showWarningViewTwo(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningSave.fxml";
        LoadedView<WarningViewController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), owner, "Warning", true).showAndWait();
        return view.getController().isConfirmed();
    }

    public static void showAddStudentView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/modal/AddStudent.fxml";
        LoadedView<AddStudentViewController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), owner, "Add Student", true).showAndWait();
    }

    // Might delete later
    public static void showErrorViewOne(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorEmptyField.fxml";
        LoadedView<DialogViewController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    public static void showErrorViewTwo(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorUserPass.fxml";
        LoadedView<DialogViewController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    public static void showSuccessWindowOne(Event event) {
        Stage current = StageManager.getCurrentStage(event);
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/SuccessStudentAdd.fxml";
        LoadedView<DialogViewController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), current, "Success", true).showAndWait();
    }

    public static void showFoundChild(VBox container, Student foundStudent) {
        String fxmlPath = "/com/school/studentmanagementfx/view/child/Found.fxml";
        LoadedView<FoundStudentViewController> view = StageManager.loadView(fxmlPath);
        view.getController().setStudentIdLabel(foundStudent.getId().get());
        view.getController().setStudentNameLabel(foundStudent.getName().get());
        view.getController().getViewStudentDetailButton().setOnAction(event -> {
            ViewManager.showStudentDetailView(event, foundStudent);
        });
        container.getChildren().add(view.getRoot());
    }

    public static void showNotFoundChild(VBox container) {
        String fxmlPath = "/com/school/studentmanagementfx/view/child/NotFound.fxml";
        LoadedView<Object> view = StageManager.loadView(fxmlPath);
        container.getChildren().add(view.getRoot());
    }
}
