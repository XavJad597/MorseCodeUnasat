package com.unasat.morsecodeunasat;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class WeightConverterUI<Scene> {
    private TextField poundField;
    private TextField kilogramField;
    private VBox layout;
    private Scene scene;

    public WeightConverterUI() {
        poundField = new TextField();
        kilogramField = new TextField();

        Button convertToKgButton = new Button("Convert to KG");
        Button convertToLbsButton = new Button("Convert to LBS");
        Button switchButton = new Button("Switch");
        Button helpButton = new Button("?");

        convertToKgButton.setOnAction(e -> convertToKilograms());
        convertToLbsButton.setOnAction(e -> convertToPounds());
        switchButton.setOnAction(e -> switchValues());
        helpButton.setOnAction(e -> showHelp());

        VBox layout = new VBox(10, poundField, kilogramField, convertToKgButton, convertToLbsButton, switchButton, helpButton);
        layout.setPadding(new Insets(10));

        Scene scene;

    }

    public VBox getLayout() {
        return layout;
    }

    private void convertToKilograms() {
        // Implement conversion logic
    }

    private void convertToPounds() {
        // Implement conversion logic
    }

    private void switchValues() {
        // Implement switching logic
    }

    private void showHelp() {

    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }
}
