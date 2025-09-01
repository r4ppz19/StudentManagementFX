package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.view.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WarningController {

    private boolean confirmed = false;

    @FXML
    private void onYesAction(ActionEvent event) {
        confirmed = true;
        StageManager.getCurrentStage(event).close();
    }

    @FXML
    private void onNoAction(ActionEvent event) {
        confirmed = false;
        StageManager.getCurrentStage(event).close();
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
