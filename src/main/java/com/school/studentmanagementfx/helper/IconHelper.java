package com.school.studentmanagementfx.helper;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class IconHelper {
    private static final String ICON_PATH = "/com/school/studentmanagementfx/image/icon.png";

    private static final Image APP_ICON = new Image(
            Objects.requireNonNull(IconHelper.class.getResourceAsStream(ICON_PATH)));

    public static void setAppIcon(Stage stage) {
        stage.getIcons().add(APP_ICON);
    }
}
