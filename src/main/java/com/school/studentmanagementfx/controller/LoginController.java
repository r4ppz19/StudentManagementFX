package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.helper.CreateWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class LoginController {
    private static final String FIXED_USERNAME = "admin";
    private static final String FIXED_PASSWORD = "admin";

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void onLoginAction(ActionEvent event) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (FIXED_USERNAME.equals(username) && FIXED_PASSWORD.equals(password)) {
            String homePageFxml = "/com/school/studentmanagementfx/view/HomeView.fxml";
            CreateWindow.createNewWindowAndClose(event, homePageFxml, "StudentManagementFX");
            clearFields();
        } else {
            System.out.println("Wrong username or password");
            String errorUserPass = "/com/school/studentmanagementfx/view/alert/ErrorUserPass.fxml";
            CreateWindow.createModalWindow(event, errorUserPass, "Error");
            clearFields();
        }
    }

    private void clearFields() {
        usernameTextField.clear();
        passwordTextField.clear();
    }
}