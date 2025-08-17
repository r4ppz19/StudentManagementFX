package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.WindowManager;
import com.school.studentmanagementfx.model.AdminConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private final AdminConfig adminConfig = AdminConfig.getInstance();

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void onLoginAction(ActionEvent event) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (adminConfig.authenticate(username, password)) {
            String homePageFxml = "/com/school/studentmanagementfx/view/HomeView.fxml";
            WindowManager.createNewWindowAndClose(event, homePageFxml, "StudentManagementFX");
            clearFields();
        } else {
            System.out.println("Wrong username or password");
            String errorUserPass = "/com/school/studentmanagementfx/view/alert/ErrorUserPass.fxml";
            WindowManager.createModalWindow(event, errorUserPass, "Error");
            clearFields();
        }
    }

    private void clearFields() {
        usernameTextField.clear();
        passwordTextField.clear();
    }
}