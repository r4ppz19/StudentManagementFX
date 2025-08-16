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
            Stage current = WindowManager.getCurrentStage(event);
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource("/com/school/studentmanagementfx/view/modal/StudentDetails.fxml"));
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
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource("/com/school/studentmanagementfx/view/dialog/WarningDelete.fxml"));
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
            Parent root = WindowManager.loadFXML("/com/school/studentmanagementfx/view/modal/AddStudent.fxml");
            WindowManager.createWindow(root, owner, "Add Student", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showErrorViewOne(ActionEvent event) {
        try {
            Stage current = WindowManager.getCurrentStage(event);
            Parent root = WindowManager.loadFXML("/com/school/studentmanagementfx/view/dialog/ErrorEmptyField.fxml");
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showErrorViewTwo(ActionEvent event) {
        try {
            Stage current = WindowManager.getCurrentStage(event);
            Parent root = WindowManager.loadFXML("/com/school/studentmanagementfx/view/dialog/ErrorUserPass.fxml");
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showSuccessWindowOne(ActionEvent event) {
        try {
            Stage current = WindowManager.getCurrentStage(event);
            Parent root = WindowManager.loadFXML("/com/school/studentmanagementfx/view/dialog/SuccessStudentAdd.fxml");
            WindowManager.createWindow(root, current, "Error", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showHomeView(ActionEvent event) {
        try {
            Stage current = WindowManager.getCurrentStage(event);
            Parent root = WindowManager.loadFXML("/com/school/studentmanagementfx/view/HomeView.fxml");
            WindowManager.createWindow(root, current, "Error", false);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
