module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires controlsfx;

    opens org.example to javafx.fxml;
    exports org.example;
}