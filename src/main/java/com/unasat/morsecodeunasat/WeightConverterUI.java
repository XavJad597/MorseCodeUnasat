package com.unasat.morsecodeunasat;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class WeightConverterUI {
    private TextField poundField;
    private TextField kilogramField;
    private VBox layout;

    public WeightConverterUI() {
        poundField = new TextField();
        poundField.setPromptText("Enter pounds");
        poundField.setPrefWidth(120); // Set preferred width
        poundField.setPrefHeight(30); // Set preferred height

        kilogramField = new TextField();
        kilogramField.setPromptText("Enter kilograms");
        kilogramField.setPrefWidth(120); // Set preferred width
        kilogramField.setPrefHeight(30); // Set preferred height

        Button convertButton = new Button("Convert");
        Button switchButton = new Button("Switch");
        Button clearButton = new Button("Clear");
        Button helpButton = new Button("?");

        convertButton.setOnAction(e -> convert());
        switchButton.setOnAction(e -> switchValues());
        clearButton.setOnAction(e -> clearValues());
        helpButton.setOnAction(e -> showHelp());

        // Apply styling
        convertButton.setStyle("-fx-background-color: #87CEFA; -fx-text-fill: white;");
        switchButton.setStyle("-fx-background-color: #808080; -fx-text-fill: white;");
        clearButton.setStyle("-fx-background-color: #87CEFA; -fx-text-fill: white;");
        helpButton.setStyle("-fx-background-color: #808080; -fx-text-fill: white;");

        layout = new VBox(10, poundField, kilogramField, convertButton, switchButton, clearButton, helpButton);
        layout.setPadding(new Insets(10));
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public VBox getLayout() {
        return layout;
    }

    private void convert() {
        if (!poundField.getText().isEmpty() && kilogramField.getText().isEmpty()) {
            try {
                double pounds = Double.parseDouble(poundField.getText());
                double kilograms = WeightConverter.convertPoundsToKilograms(pounds);
                kilogramField.setText(String.format("%.2f", kilograms));
            } catch (NumberFormatException ex) {
                showAlert("Please enter a valid number for pounds.");
            }
        } else if (poundField.getText().isEmpty() && !kilogramField.getText().isEmpty()) {
            try {
                double kilograms = Double.parseDouble(kilogramField.getText());
                double pounds = WeightConverter.convertKilogramsToPounds(kilograms);
                poundField.setText(String.format("%.2f", pounds));
            } catch (NumberFormatException ex) {
                showAlert("Please enter a valid number for kilograms.");
            }
        } else {
            showAlert("Please fill only one field to convert.");
        }
    }

    private void switchValues() {
        String temp = poundField.getText();
        poundField.setText(kilogramField.getText());
        kilogramField.setText(temp);
    }

    private void clearValues() {
        poundField.clear();
        kilogramField.clear();
    }

    private void showHelp() {
        showAlert("Enter a weight in pounds or kilograms and click Convert.");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }
}
