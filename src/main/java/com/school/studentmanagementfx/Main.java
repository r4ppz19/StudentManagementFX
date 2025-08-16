package com.school.studentmanagementfx;

import com.school.studentmanagementfx.util.SetIcon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        String mainMenuViewFxml = "/com/school/studentmanagementfx/view/LoginView.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(mainMenuViewFxml));
        Scene scene = new Scene(fxmlLoader.load());
        SetIcon.setAppIcon(stage);
        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }
}
