module MVC {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens MVC to javafx.fxml;
    exports exceptions;
    exports GUI;
    exports MVC;
    exports parties;
    exports politicians;
    exports strategy;
    exports voting;
}