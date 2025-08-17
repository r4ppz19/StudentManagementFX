package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.controller.AddStudentController;
import com.school.studentmanagementfx.controller.DialogController;
import com.school.studentmanagementfx.controller.FoundStudentController;
import com.school.studentmanagementfx.controller.HomeViewController;
import com.school.studentmanagementfx.controller.LoginViewController;
import com.school.studentmanagementfx.controller.StudentDetailsController;
import com.school.studentmanagementfx.controller.WarningController;
import com.school.studentmanagementfx.model.Student;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewManager {

    public static void showLoginView(Stage stage) {
        String fxmlPath = "/com/school/studentmanagementfx/view/LoginView.fxml";
        LoadedView<LoginViewController> view = WindowManager.loadView(fxmlPath);
        Scene scene = new Scene(view.getRoot());
        SetIcon.setAppIcon(stage);
        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void showFoundChild(VBox container, Student foundStudent) {
        String fxmlPath = "/com/school/studentmanagementfx/view/child/Found.fxml";
        LoadedView<FoundStudentController> view = WindowManager.loadView(fxmlPath);
        view.getController().setStudentIdLabel(foundStudent.getId().get());
        view.getController().setStudentNameLabel(foundStudent.getName().get());
        view.getController().getViewStudentDetailButton().setOnAction(event -> {
            ViewManager.showStudentDetailView(event, foundStudent);
        });
        container.getChildren().add(view.getRoot());
    }

    public static void showNotFoundChild(VBox container) {
        String fxmlPath = "/com/school/studentmanagementfx/view/child/NotFound.fxml";
        LoadedView<Object> view = WindowManager.loadView(fxmlPath);
        container.getChildren().add(view.getRoot());
    }

    public static void showStudentDetailView(Event event, Student student) {
        String fxmlPath = "/com/school/studentmanagementfx/view/modal/StudentDetails.fxml";
        Stage current = WindowManager.getCurrentStage(event);
        LoadedView<StudentDetailsController> view = WindowManager.loadView(fxmlPath);
        view.getController().setStudent(student);
        WindowManager.createWindow(view.getRoot(), current, "Student Detail", true).showAndWait();
    }

    public static boolean showWarningView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningDelete.fxml";
        LoadedView<WarningController> view = WindowManager.loadView(fxmlPath);
        WindowManager.createWindow(view.getRoot(), owner, "Warning", true).showAndWait();
        return view.getController().isConfirmed();
    }

    public static void showAddStudentView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/modal/AddStudent.fxml";
        LoadedView<AddStudentController> view = WindowManager.loadView(fxmlPath);
        WindowManager.createWindow(view.getRoot(), owner, "Add Student", true).showAndWait();
    }

    public static void showErrorViewOne(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorEmptyField.fxml";
        LoadedView<DialogController> view = WindowManager.loadView(fxmlPath);
        Stage current = WindowManager.getCurrentStage(event);
        WindowManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    public static void showErrorViewTwo(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorUserPass.fxml";
        LoadedView<DialogController> view = WindowManager.loadView(fxmlPath);
        Stage current = WindowManager.getCurrentStage(event);
        WindowManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    public static void showSuccessWindowOne(Event event) {
        Stage current = WindowManager.getCurrentStage(event);
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/SuccessStudentAdd.fxml";
        LoadedView<DialogController> view = WindowManager.loadView(fxmlPath);
        WindowManager.createWindow(view.getRoot(), current, "Success", true).showAndWait();
    }

    public static void showHomeView(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/HomeView.fxml";
        LoadedView<HomeViewController> view = WindowManager.loadView(fxmlPath);
        Stage current = WindowManager.getCurrentStage(event);
        WindowManager.createWindow(view.getRoot(), current, "Student Management", false).show();
        current.close();
    }
}
