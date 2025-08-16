package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.controller.StudentDetailsController;
import com.school.studentmanagementfx.controller.WarningController;
import com.school.studentmanagementfx.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {

    public static void showStudentDetailView(ActionEvent event, Student student) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/modal/StudentDetails.fxml";
            Stage current = WindowManager.getCurrentStage(event);
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource(fxmlPath));
            Parent root = loader.load();
            StudentDetailsController studentDetailsController = loader.getController();
            studentDetailsController.setStudent(student);
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean showWarningView(Stage owner) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/dialog/WarningDelete.fxml";
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource(fxmlPath));
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
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showHomeView(ActionEvent event) {
        try {
            String fxmlPath = "/com/school/studentmanagementfx/view/HomeView.fxml";
            Parent root = WindowManager.loadFXML(fxmlPath);
            Stage current = WindowManager.getCurrentStage(event);
            WindowManager.createWindow(root, current, "Error", false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
