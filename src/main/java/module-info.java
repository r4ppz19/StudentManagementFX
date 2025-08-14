module com.school.studentmanagementfx {
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.school.studentmanagementfx to javafx.fxml;
    opens com.school.studentmanagementfx.controller to javafx.fxml;
    opens com.school.studentmanagementfx.helper to javafx.fxml;

    exports com.school.studentmanagementfx;
    exports com.school.studentmanagementfx.controller;
    exports com.school.studentmanagementfx.helper;
    exports com.school.studentmanagementfx.model;
}