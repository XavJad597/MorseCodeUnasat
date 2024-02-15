module com.unasat.morsecodeunasat {
    // JavaFX modules required for UI components, FXML, web components, and media playback.
    requires javafx.controls; // Basic UI controls like buttons, text fields, etc.
    requires javafx.fxml; // Support for loading FXML files for UI design.
    requires javafx.web; // Web view and web-related components.
    requires javafx.media; // Media playback components.

    // Third-party libraries for enhanced UI components and validation.
    requires org.controlsfx.controls; // Additional UI controls and components for JavaFX.
    requires net.synedra.validatorfx; // Framework for easy validation of UI components.
    requires org.kordamp.ikonli.javafx; // Icons library for JavaFX applications.
    requires org.kordamp.bootstrapfx.core; // BootstrapFX for applying Bootstrap styles to JavaFX components.
    requires eu.hansolo.tilesfx; // TilesFX for creating tile-based dashboards and UI elements.

    // Configuration for runtime reflection and FXML.
    opens com.unasat.morsecodeunasat to javafx.fxml; // Allows FXML files in the specified package to access controllers and other components.
    exports com.unasat.morsecodeunasat; // Exports the specified package to make its public types available to other modules.
}
