package com.school.studentmanagementfx.util;

import com.school.studentmanagementfx.service.AddStudentValidator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Map;

public class StudentForm {

    public static boolean validateAndShowErrors(Map<String, Label> errorLabels, Map<String, TextField> textFields) {
        clearErrorLabels(errorLabels);

        Map<String, String> errors = AddStudentValidator.validateFields(
                textFields.get("id").getText(), textFields.get("name").getText(), textFields.get("age").getText(),
                textFields.get("birthday").getText(), textFields.get("address").getText(),
                textFields.get("course").getText(),
                textFields.get("year").getText(), textFields.get("email").getText());

        if (!errors.isEmpty()) {
            showErrors(errors, errorLabels);
            return true;
        }
        return false;
    }

    public static void clearFields(Map<String, TextField> textFields) {
        if (textFields == null)
            return;
        textFields.values().forEach(tf -> {
            if (tf != null)
                tf.clear();
        });
    }

    public static void setFieldsEditable(boolean editable, Map<String, TextField> textFields) {
        if (textFields == null)
            return;
        textFields.values().forEach(field -> {
            if (field != null)
                field.setEditable(editable);
        });
    }

    private static void showErrors(Map<String, String> errors, Map<String, Label> errorLabels) {
        if (errors == null || errorLabels == null)
            return;
        errors.forEach((field, message) -> {
            if (field == null)
                return;
            Label label = errorLabels.get(field);
            if (label != null) {
                label.setText(message == null ? "" : message.trim());
            }
        });
    }

    private static void clearErrorLabels(Map<String, Label> errorLabels) {
        if (errorLabels == null)
            return;
        errorLabels.values().forEach(label -> {
            if (label != null)
                label.setText("");
        });
    }
}
