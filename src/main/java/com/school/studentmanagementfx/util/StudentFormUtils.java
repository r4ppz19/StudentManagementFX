package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.service.AddStudentValidator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Map;

public class StudentFormUtils {

    public static boolean validateAndShowErrors(Map<String, Label> errorLabels, Map<String, TextField> textFields) {
        clearErrorLabels(errorLabels);

        Map<String, String> errors = AddStudentValidator.validateFields(
                textFields.get("id").getText(),
                textFields.get("name").getText(),
                textFields.get("age").getText(),
                textFields.get("birthday").getText(),
                textFields.get("address").getText(),
                textFields.get("course").getText(),
                textFields.get("year").getText(),
                textFields.get("email").getText());

        if (!errors.isEmpty()) {
            showErrors(errors, errorLabels);
            return true;
        }
        return false;
    }

    public static void clearFields(Map<String, TextField> textFields) {
        textFields.values().forEach(TextField::clear);
    }

    public static void setFieldsEditable(boolean editable, Map<String, TextField> textFields) {
        textFields.values().forEach((field) -> field.setEditable(editable));
    }

    private static void showErrors(Map<String, String> errors, Map<String, Label> errorLabels) {
        errors.forEach((field, message) -> {
            Label label = errorLabels.get(field);
            if (label != null) {
                label.setText(message == null ? "" : message.trim());
            }
        });
    }

    private static void clearErrorLabels(Map<String, Label> errorLabels) {
        errorLabels.values().forEach(label -> label.setText(""));
    }
}
