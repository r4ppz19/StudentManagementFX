package com.school.studentmanagementfx.controller;

import com.school.studentmanagementfx.util.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {

    private static final String FIXED_USERNAME = "admin";
    private static final String FIXED_PASSWORD = "admin";

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void onLoginAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (FIXED_USERNAME.equals(username) && FIXED_PASSWORD.equals(password)) {
            ViewManager.showHomeView(event);
            clearFields();
        } else {
            ViewManager.showErrorViewTwo(event);
            clearFields();
        }
    }

    private void clearFields() {
        usernameTextField.clear();
        passwordTextField.clear();
    }
}
