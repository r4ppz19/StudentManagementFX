package com.school.studentmanagementfx.util;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class IconUtil {

    private static final String ICON_PATH = "/com/school/studentmanagementfx/image/icon.png";

    private static final Image APP_ICON = new Image(
            Objects.requireNonNull(IconUtil.class.getResourceAsStream(ICON_PATH)));

    public static void setAppIcon(Stage stage) {
        stage.getIcons().add(APP_ICON);
    }
}
