package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.view.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DialogController {

    @FXML
    private void onTryAgainAction(ActionEvent event) {
        StageManager.getCurrentStage(event).close();
    }
}
