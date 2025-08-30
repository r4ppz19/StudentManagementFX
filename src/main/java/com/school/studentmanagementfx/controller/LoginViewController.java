package com.school.studentmanagementfx.controller;

import java.sql.SQLException;

import com.school.studentmanagementfx.model.DBConnection;
import com.school.studentmanagementfx.view.ViewManager;
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
        try {
            DBConnection.getConnection();
        } catch (SQLException e) {
            ViewManager.showErrorNoDB(event);
            return;
        }

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (FIXED_USERNAME.equals(username) && FIXED_PASSWORD.equals(password)) {
            ViewManager.showHomeView(event);
        } else {
            ViewManager.showErrorUserPassView(event);
        }
    }
}
