package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.SetIcon;
import com.school.studentmanagementfx.helper.WindowManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WarningController {
    private boolean confirmed = false;
    private Stage stage;

    public static boolean showWarningWindow(Stage parentStage) {
        try {
            String warningDeleteFxml = "/com/school/studentmanagementfx/view/alert/WarningDelete.fxml";
            FXMLLoader loader = new FXMLLoader(WarningController.class.getResource(warningDeleteFxml));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(parentStage);
            stage.setTitle("Warning");
            stage.setResizable(false);
            stage.setFullScreen(false);
            SetIcon.setAppIcon(stage);
            WindowManager.centerWindow(parentStage, stage);

            WarningController controller = loader.getController();
            controller.setStage(stage);

            stage.showAndWait();
            return controller.isConfirmed();
        } catch (IOException e) {
            return false;
        }
    }

    @FXML
    private void onYesAction() {
        confirmed = true;
        stage.close();
    }

    @FXML
    private void onNoAction() {
        confirmed = false;
        stage.close();
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
