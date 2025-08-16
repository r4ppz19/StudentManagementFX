module com.school.studentmanagementfx {
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.school.studentmanagementfx to javafx.fxml;
    opens com.school.studentmanagementfx.controller to javafx.fxml;
    opens com.school.studentmanagementfx.util to javafx.fxml;

    exports com.school.studentmanagementfx;
    exports com.school.studentmanagementfx.controller;
    exports com.school.studentmanagementfx.util;
    exports com.school.studentmanagementfx.model;
}