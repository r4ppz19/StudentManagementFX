package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AlertController {
    @FXML
    private void onTryAgainAction(ActionEvent event) {
        WindowManager.getCurrentStage(event).close();
    }

    public static void showErrorWindowOne(ActionEvent event) {
        String errorViewFxml = "/com/school/studentmanagementfx/view/alert/ErrorEmptyField.fxml";
        WindowManager.createModalWindow(event, errorViewFxml, "Error");
    }

    public static void showErrorWindowTwo(ActionEvent event) {
        String errorUserPass = "/com/school/studentmanagementfx/view/alert/ErrorUserPass.fxml";
        WindowManager.createModalWindow(event, errorUserPass, "Error");
    }

    public static void showSuccessWindowOne(ActionEvent event) {
        String successViewFxml = "/com/school/studentmanagementfx/view/alert/SuccessStudentAdd.fxml";
        WindowManager.createModalWindow(event, successViewFxml, "Success");
    }
}
