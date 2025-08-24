module com.school.studentmanagementfx {
    // JavaFX
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    // IconFonts
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;

    opens com.school.studentmanagementfx to javafx.fxml, javafx.graphics;
    opens com.school.studentmanagementfx.controller to javafx.fxml;
    opens com.school.studentmanagementfx.view to javafx.fxml;
}
