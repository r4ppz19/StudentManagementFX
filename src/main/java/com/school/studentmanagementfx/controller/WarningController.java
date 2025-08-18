package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.view.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WarningController {

    private boolean confirmed = false;

    @FXML
    private void onYesAction(ActionEvent event) {
        confirmed = true;
        WindowManager.getCurrentStage(event).close();
    }

    @FXML
    private void onNoAction(ActionEvent event) {
        confirmed = false;
        WindowManager.getCurrentStage(event).close();
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
