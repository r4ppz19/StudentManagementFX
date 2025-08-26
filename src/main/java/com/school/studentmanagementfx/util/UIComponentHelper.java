package com.school.studentmanagementfx.util;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Map;

public class UIComponentHelper {
    public static void setFieldsEditable(Map<String, TextField> textFields, boolean editable) {
        textFields.values().forEach((field) -> field.setEditable(editable));
    }

    public static void showButton(Button button, boolean visible) {
        button.setVisible(visible);
        button.setManaged(visible);
    }

    public static void clearFields(Map<String, TextField> textFields) {
        textFields.values().forEach(TextField::clear);
    }
}
