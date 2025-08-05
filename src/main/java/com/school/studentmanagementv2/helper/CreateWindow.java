package com.school.studentmanagementv2.helper;

import com.school.studentmanagementv2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateWindow {

    public static void createWindow(ActionEvent event, String fxmlPath, String windowTitle) throws IOException {
        Stage addStudentStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        addStudentStage.setTitle(windowTitle);
        addStudentStage.setScene(scene);
        addStudentStage.initModality(Modality.APPLICATION_MODAL);
        addStudentStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        addStudentStage.setResizable(false);
        addStudentStage.setFullScreen(false);
        addStudentStage.showAndWait();
    }
}
