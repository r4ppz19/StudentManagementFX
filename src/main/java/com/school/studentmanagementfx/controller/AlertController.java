package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AlertController {
    @FXML
    private void onTryAgainAction(ActionEvent event) {
        WindowManager.getCurrentStage(event).close();
    }
}
