package com.school.studentmanagementfx.util;

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

    public static void createWindow(Parent root, Stage owner, String title, boolean modal) {
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        SetIcon.setAppIcon(stage);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setFullScreen(false);
        centerWindow(owner, stage);

        if (modal) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(owner);
            stage.showAndWait();
        } else {
            owner.close();
            stage.show();
        }
    }

    public static Stage getCurrentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static Parent loadFXML(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        return loader.load();
    }

    private static void centerWindow(Stage parentStage, Stage childStage) {
        childStage.setOnShown(e -> {
            double centerX = parentStage.getX() + parentStage.getWidth() / 2 - childStage.getWidth() / 2;
            double centerY = parentStage.getY() + parentStage.getHeight() / 2 - childStage.getHeight() / 2;
            childStage.setX(centerX);
            childStage.setY(centerY);
        });
    }
}
