package com.school.studentmanagementfx;

import com.school.studentmanagementfx.service.StudentFileService;
import com.school.studentmanagementfx.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ViewManager.showLoginView(stage);
    }

    @Override
    public void stop() {
        StudentFileService.saveToDataBase();
    }
}
