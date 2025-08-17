package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.controller.FoundStudentController;
import com.school.studentmanagementfx.controller.StudentDetailsController;
import com.school.studentmanagementfx.controller.WarningController;
import com.school.studentmanagementfx.model.Student;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewManager {

    public static void showFoundChild(VBox container, Student foundStudent) {
        try {
            String foundFxml = "/com/school/studentmanagementfx/view/child/Found.fxml";
            FXMLLoader loader = new FXMLLoader(
                    ViewManager.class.getResource(foundFxml));
            Node childNode = loader.load();

            FoundStudentController foundStudentController = loader.getController();
            foundStudentController.setStudentIdLabel(foundStudent.getId().get());
            foundStudentController.setStudentNameLabel(foundStudent.getName().get());

            foundStudentController
                    .getViewStudentDetailButton()
                    .setOnAction(event -> {
                        ViewManager.showStudentDetailView(event, foundStudent);
                    });
            container.getChildren().add(childNode);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showNotFoundChild(VBox container) {
        try {
            String notFoundFxml = "/com/school/studentmanagementfx/view/child/NotFound.fxml";
            FXMLLoader loader = new FXMLLoader(
                    ViewManager.class.getResource(notFoundFxml));
            container.getChildren().add(loader.load());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showLoginView(Stage stage) {
        try {
            String mainMenuViewFxml = "/com/school/studentmanagementfx/view/LoginView.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(
                    ViewManager.class.getResource(mainMenuViewFxml));
            Scene scene = new Scene(fxmlLoader.load());
            SetIcon.setAppIcon(stage);
            stage.setTitle("Student Management");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setFullScreen(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showStudentDetailView(ActionEvent event, Student student) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/modal/StudentDetails.fxml";
            Stage current = WindowManager.getCurrentStage(event);
            FXMLLoader loader = new FXMLLoader(
                    ViewManager.class.getResource(fxmlPath));
            Parent root = loader.load();
            StudentDetailsController studentDetailsController = loader.getController();
            studentDetailsController.setStudent(student);
            WindowManager.createWindow(root, current, "Student Detail", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean showWarningView(Stage owner) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningDelete.fxml";
            FXMLLoader loader = new FXMLLoader(
                    ViewManager.class.getResource(fxmlPath));
            Parent root = loader.load();
            WarningController warningController = loader.getController();
            WindowManager.createWindow(root, owner, "Warning", true);
            return warningController.isConfirmed();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void showAddStudentView(Stage owner) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/modal/AddStudent.fxml";
            Parent root = WindowManager.loadFXML(fxmlPath);
            WindowManager.createWindow(root, owner, "Add Student", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showErrorViewOne(ActionEvent event) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorEmptyField.fxml";
            Parent root = WindowManager.loadFXML(fxmlPath);
            Stage current = WindowManager.getCurrentStage(event);
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showErrorViewTwo(ActionEvent event) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/dialog/ErrorUserPass.fxml";
            Parent root = WindowManager.loadFXML(fxmlPath);
            Stage current = WindowManager.getCurrentStage(event);
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showSuccessWindowOne(ActionEvent event) {
        try {
            Stage current = WindowManager.getCurrentStage(event);
            String fxmlPath = "/com/school/studentmanagementfx/view/dialog/SuccessStudentAdd.fxml";
            Parent root = WindowManager.loadFXML(fxmlPath);
            WindowManager.createWindow(root, current, "Success", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showHomeView(ActionEvent event) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/HomeView.fxml";
            Parent root = WindowManager.loadFXML(fxmlPath);
            Stage current = WindowManager.getCurrentStage(event);
            WindowManager.createWindow(root, current, "Student Management", false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
