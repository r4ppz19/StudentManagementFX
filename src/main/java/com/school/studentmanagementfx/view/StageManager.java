package com.school.studentmanagementfx.view;

import com.school.studentmanagementfx.util.IconUtil;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {

    public static void setupPrimaryStage(Stage stage, Parent root, String title) {
        configureStage(stage, root, title, false, null);
        stage.show();
    }

    public static Stage createModalWindow(Parent root, Stage owner, String title) {
        Stage stage = new Stage();
        configureStage(stage, root, title, true, owner);
        return stage;
    }

    public static void switchScene(Stage stage, Parent root, String title) {
        stage.setScene(new Scene(root));
        stage.setTitle(title);
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

    private static void configureStage(Stage stage, Parent root, String title, boolean modal, Stage owner) {
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setFullScreen(false);
        IconUtil.setAppIcon(stage);

        if (modal && owner != null) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(owner);
            centerWindow(owner, stage);
        }
    }
}
