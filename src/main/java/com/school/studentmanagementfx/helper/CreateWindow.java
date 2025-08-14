package com.school.studentmanagementfx.helper;

import com.school.studentmanagementfx.Main;
import com.school.studentmanagementfx.controller.StudentDetailsController;
import com.school.studentmanagementfx.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateWindow {

    public static void showStudentDetails(ActionEvent event, Student student) {
        try {
            Stage parentStage = getParentStage(event);
            String fxmlPath = "/com/school/studentmanagementfx/view/StudentDetailsView.fxml";

            FXMLLoader loader = new FXMLLoader(CreateWindow.class.getResource(fxmlPath));
            Parent root = loader.load();

            StudentDetailsController controller = loader.getController();
            controller.setStudent(student);

            createWindow(root, parentStage, "Student Details");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewWindowAndClose(ActionEvent event, String fxmlPath, String title) throws IOException {
        Stage parentStage = getParentStage(event);
        parentStage.close();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Parent root = loader.load();
        createWindow(root, parentStage, title);
        parentStage.show();
    }

    public static void createModalWindow(ActionEvent event, String fxmlPath, String title) throws IOException {
        Stage parentStage = getParentStage(event);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Parent root = loader.load();
        createWindow(root, parentStage, title);
    }

    private static void createWindow(Parent root, Stage parentStage, String title) {
        Stage childStage = new Stage();
        SetIcon.setAppIcon(childStage);
        childStage.setScene(new Scene(root));
        childStage.setTitle(title);
        childStage.initModality(Modality.WINDOW_MODAL);
        childStage.initOwner(parentStage);
        childStage.setResizable(false);
        childStage.setFullScreen(false);

        childStage.setOnShown(e -> {
            double centerX = parentStage.getX() + parentStage.getWidth() / 2 - childStage.getWidth() / 2;
            double centerY = parentStage.getY() + parentStage.getHeight() / 2 - childStage.getHeight() / 2;
            childStage.setX(centerX);
            childStage.setY(centerY);
        });

        childStage.showAndWait();
    }

    private static Stage getParentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }
}
