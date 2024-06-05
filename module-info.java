module src.gui {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.swing;
    requires java.sql;

    opens src.gui to javafx.fxml, javafx.controls,javafx.graphics;
    exports src.gui;
}