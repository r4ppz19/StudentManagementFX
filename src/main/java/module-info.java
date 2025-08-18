module com.school.studentmanagementfx {
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.school.studentmanagementfx to javafx.fxml, javafx.graphics;
    opens com.school.studentmanagementfx.controller to javafx.fxml;
    opens com.school.studentmanagementfx.model to javafx.base;
    opens com.school.studentmanagementfx.view to javafx.fxml;
}
