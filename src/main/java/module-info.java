module com.school.studentmanagementv2 {
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.school.studentmanagementv2 to javafx.fxml;
    opens com.school.studentmanagementv2.controller to javafx.fxml;
    opens com.school.studentmanagementv2.helper to javafx.fxml;

    exports com.school.studentmanagementv2;
    exports com.school.studentmanagementv2.controller;
    exports com.school.studentmanagementv2.helper;
}