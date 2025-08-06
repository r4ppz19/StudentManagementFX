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
    public static void createWindow(ActionEvent event, String fxmlPath) throws IOException {
        Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        parentStage.hide();
        Stage childStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        childStage.setScene(scene);
        childStage.setTitle("Student Management");
        childStage.initModality(Modality.APPLICATION_MODAL);
        childStage.initOwner(parentStage);
        childStage.setResizable(false);
        childStage.setFullScreen(false);
        childStage.showAndWait();
        parentStage.show();
    }
}
