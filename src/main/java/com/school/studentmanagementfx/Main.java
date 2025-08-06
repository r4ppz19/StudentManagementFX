package com.school.studentmanagementv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String MAIN_MENU_VIEW_FXML = "/com/school/studentmanagementv2/view/MainMenuView.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(MAIN_MENU_VIEW_FXML));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
