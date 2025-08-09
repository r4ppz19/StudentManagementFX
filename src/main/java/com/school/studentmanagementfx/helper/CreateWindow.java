package com.school.studentmanagementfx.helper;

import com.school.studentmanagementfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateWindow {
    public static void createWindowAndHide(ActionEvent event, String fxmlPath) throws IOException {
        Stage parentStage = getParentStage(event);
        parentStage.hide();
        createWindow(fxmlPath, parentStage);
        parentStage.show();
    }

    public static void createModalWindow(ActionEvent event, String fxmlPath) throws IOException {
        Stage parentStage = getParentStage(event);
        createWindow(fxmlPath, parentStage);
    }

    private static void createWindow(String fxmlPath, Stage parentStage) throws IOException {
        Stage childStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        IconHelper.setAppIcon(childStage);
        childStage.setScene(scene);
        childStage.setTitle("Student Management");
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
