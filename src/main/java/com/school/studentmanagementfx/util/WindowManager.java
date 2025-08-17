package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.Main;
import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowManager {

    public static Stage createWindow(Parent root, Stage owner, String title, boolean modal) {
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        SetIcon.setAppIcon(stage);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setFullScreen(false);
        centerWindow(owner, stage);

        if (modal) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(owner);
        }

        return stage;
    }

    public static Stage getCurrentStage(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static Parent loadFXML(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        return loader.load();
    }

    public static <T> LoadedView<T> loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Parent root = loader.load();
            T controller = loader.getController();
            return new LoadedView<>(root, controller);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
    }

    private static void centerWindow(Stage parentStage, Stage childStage) {
        childStage.setOnShown(e -> {
            double centerX = parentStage.getX() +
                    parentStage.getWidth() / 2 -
                    childStage.getWidth() / 2;
            double centerY = parentStage.getY() +
                    parentStage.getHeight() / 2 -
                    childStage.getHeight() / 2;
            childStage.setX(centerX);
            childStage.setY(centerY);
        });
    }
}
