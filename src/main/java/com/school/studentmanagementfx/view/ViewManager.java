package com.school.studentmanagementfx.view;

import com.school.studentmanagementfx.controller.*;
import com.school.studentmanagementfx.model.Student;
import com.school.studentmanagementfx.util.IconUtil;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewManager {

    // First window creation, parameter stage from JavaFX
    public static void initializeMainStage(Stage stage) {
        String fxmlPath = "/com/school/studentmanagementfx/view/LoginView.fxml";
        LoadedView<LoginController> view = StageManager.loadView(fxmlPath);
        Scene scene = new Scene(view.getRoot());
        IconUtil.setAppIcon(stage);
        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void showLoginView(Stage stage) {
        String fxmlPath = "/com/school/studentmanagementfx/view/LoginView.fxml";
        LoadedView<LoginController> view = StageManager.loadView(fxmlPath);
        StageManager.switchScene(stage, view.getRoot(), "Student Management");
    }

    public static void showHomeView(Event event, Stage stage) {
        String fxmlPath = "/com/school/studentmanagementfx/view/HomeView.fxml";
        LoadedView<HomeController> view = StageManager.loadView(fxmlPath);
        StageManager.switchScene(stage, view.getRoot(), "Student Management");
    }

    @Deprecated // delete later
    public static void showHomeView(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/HomeView.fxml";
        LoadedView<HomeController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Student Management", false).show();
        current.close();
    }

    // Pop up modals
    public static void showStudentDetailView(Event event, Student student) {
        String fxmlPath = "/com/school/studentmanagementfx/view/modal/StudentDetail.fxml";
        LoadedView<StudentDetailController> view = StageManager.loadView(fxmlPath);
        view.getController().setStudent(student);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Student Detail", true).showAndWait();
    }

    public static void showAddStudentView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/modal/AddStudent.fxml";
        LoadedView<AddStudentController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), owner, "Add Student", true).showAndWait();
    }

    @Deprecated // might delete later
    public static void showErrorEmptyFieldView(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorEmptyField.fxml";
        LoadedView<DialogController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    // Insert child views
    public static void showFoundChild(VBox container, Student foundStudent) {
        String fxmlPath = "/com/school/studentmanagementfx/view/child/Found.fxml";
        LoadedView<FoundStudentController> view = StageManager.loadView(fxmlPath);
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

    // Pop up normal dialog modals
    public static void showErrorUserPassView(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorUserPass.fxml";
        LoadedView<DialogController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    public static void showSuccessStudentAddView(Event event) {
        Stage current = StageManager.getCurrentStage(event);
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/SuccessStudentAdd.fxml";
        LoadedView<DialogController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), current, "Success", true).showAndWait();
    }

    public static void showErrorNoDB(Event event) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorNoDB.fxml";
        LoadedView<DialogController> view = StageManager.loadView(fxmlPath);
        Stage current = StageManager.getCurrentStage(event);
        StageManager.createWindow(view.getRoot(), current, "Error", true).showAndWait();
    }

    // Pop up warning dialog modals
    public static boolean showWarningDeleteView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningDelete.fxml";
        return showWarning(owner, fxmlPath);
    }

    public static boolean showWarningSaveView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningSave.fxml";
        return showWarning(owner, fxmlPath);
    }

    public static boolean showWarningCancelView(Stage owner) {
        String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningCancel.fxml";
        return showWarning(owner, fxmlPath);
    }

    private static boolean showWarning(Stage owner, String fxmlPath) {
        LoadedView<WarningController> view = StageManager.loadView(fxmlPath);
        StageManager.createWindow(view.getRoot(), owner, "Warning", true).showAndWait();
        return view.getController().isConfirmed();
    }
}
