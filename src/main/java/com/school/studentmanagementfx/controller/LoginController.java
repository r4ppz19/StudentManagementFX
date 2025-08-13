package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private void onLoginAction(ActionEvent event) throws IOException {
        String homePageFxml = "/com/school/studentmanagementfx/view/HomeView.fxml";
        CreateWindow.createWindowAndHide(event, homePageFxml);
    }
}
