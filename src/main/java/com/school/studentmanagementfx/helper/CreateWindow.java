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

    public static void showStudentDetails(Student student) {
        try {
            String studentDetailFxml = "/com/school/studentmanagementfx/view/StudentDetailsView.fxml";
            FXMLLoader loader = new FXMLLoader(CreateWindow.class.getResource(studentDetailFxml));
            Parent root = loader.load();
            StudentDetailsController controller = loader.getController();
            controller.setStudent(student);
            Stage stage = new Stage();
            IconHelper.setAppIcon(stage);
            stage.setScene(new Scene(root));
            stage.setTitle("Student Details");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setFullScreen(false);
            stage.setResizable(false);
            stage.showAndWait();

        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void createNewWindowAndHide(ActionEvent event, String fxmlPath, String title) throws IOException {
        Stage parentStage = getParentStage(event);
        parentStage.hide();
        createWindow(fxmlPath, parentStage, title);
        parentStage.show();
    }

    public static void createModalWindow(ActionEvent event, String fxmlPath, String title) throws IOException {
        Stage parentStage = getParentStage(event);
        createWindow(fxmlPath, parentStage, title);
    }

    private static void createWindow(String fxmlPath, Stage parentStage, String title) throws IOException {
        Stage childStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        IconHelper.setAppIcon(childStage);
        childStage.setScene(scene);
        childStage.setTitle(title);
        childStage.initModality(Modality.APPLICATION_MODAL);
        childStage.initOwner(parentStage);
        childStage.setResizable(false);
        childStage.setFullScreen(false);
        childStage.showAndWait();
    }

    private static Stage getParentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }
}
