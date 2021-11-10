module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires org.junit.jupiter.api;
    requires javafx.base;

    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}