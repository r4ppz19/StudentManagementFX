package com.school.studentmanagementfx.helper;

import com.school.studentmanagementfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowManager {

    public static void createNewWindowAndClose(ActionEvent event, String fxmlPath, String title) throws IOException {
        Stage parentStage = getCurrentStage(event);
        parentStage.close();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Parent root = loader.load();
        createWindow(root, parentStage, title);
        parentStage.show();
    }

    public static void createModalWindow(ActionEvent event, String fxmlPath, String title) throws IOException {
        Stage parentStage = getCurrentStage(event);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Parent root = loader.load();
        createWindow(root, parentStage, title);
    }

    public static void createWindow(Parent root, Stage parentStage, String title) {
        Stage childStage = new Stage();
        SetIcon.setAppIcon(childStage);
        childStage.setScene(new Scene(root));
        childStage.setTitle(title);
        childStage.initModality(Modality.WINDOW_MODAL);
        childStage.initOwner(parentStage);
        childStage.setResizable(false);
        childStage.setFullScreen(false);
        centerWindow(parentStage, childStage);
        childStage.showAndWait();
    }

    public static void centerWindow(Stage parentStage, Stage childStage) {
        childStage.setOnShown(e -> {
            double centerX = parentStage.getX() + parentStage.getWidth() / 2 - childStage.getWidth() / 2;
            double centerY = parentStage.getY() + parentStage.getHeight() / 2 - childStage.getHeight() / 2;
            childStage.setX(centerX);
            childStage.setY(centerY);
        });
    }

    public static Stage getCurrentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }
}
