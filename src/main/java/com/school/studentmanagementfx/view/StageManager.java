package com.school.studentmanagementfx.view;

import com.school.studentmanagementfx.util.IconUtil;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {

    public static Stage createWindow(Parent root, Stage owner, String title, boolean modal) {
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        IconUtil.setAppIcon(stage);
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

    public static <C> LoadedView<C> loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(StageManager.class.getResource(fxmlPath));
            Parent root = loader.load();
            C controller = loader.getController();
            return new LoadedView<>(root, controller);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
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
