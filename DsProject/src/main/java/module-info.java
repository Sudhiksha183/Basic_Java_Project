module com.example.dsproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.dsproject to javafx.fxml;
    exports com.example.dsproject;
}