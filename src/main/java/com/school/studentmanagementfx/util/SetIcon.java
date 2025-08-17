package com.school.studentmanagementfx.util;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SetIcon {

    private static final String ICON_PATH = "/com/school/studentmanagementfx/image/icon.png";

    private static final Image APP_ICON = new Image(SetIcon.class.getResourceAsStream(ICON_PATH));

    public static void setAppIcon(Stage stage) {
        try {
            stage.getIcons().add(APP_ICON);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
