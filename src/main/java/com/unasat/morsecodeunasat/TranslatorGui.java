package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TranslatorGui extends Application {
    private TextArea englishTextArea;
    private TextArea morseTextArea;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Show introduction before starting the main application
            Introduction introduction = new Introduction();
            introduction.setContinueAction(() -> startTranslatorGui(primaryStage));
            introduction.showIntroduction(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    private void startTranslatorGui(Stage primaryStage) {
        // Proceed to the main application
        BorderPane root = new BorderPane();

        englishTextArea = new TextArea();
        englishTextArea.setPrefWidth(280); // Set preferred width
        englishTextArea.setPrefHeight(350); // Set preferred height

        morseTextArea = new TextArea();
        morseTextArea.setPrefWidth(280); // Set preferred width
        morseTextArea.setPrefHeight(350); // Set preferred height

        Button translateToMorseButton = new Button("Translate to Morse");
        translateToMorseButton.setOnAction(e -> translateToMorse());

        Button translateToEnglishButton = new Button("Translate to English");
        translateToEnglishButton.setOnAction(e -> translateToEnglish());

        // Adding a clear button
        Button clearButton = new Button("Clear Text");
        clearButton.setOnAction(e -> clearTextAreas());

        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(translateToEnglishButton, translateToMorseButton,clearButton);// Align buttons in the center of VBox

        root.setLeft(englishTextArea);
        root.setRight(morseTextArea);
        root.setBottom(buttonBox); // Use VBox for the buttons

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Morse Translator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void translateToMorse() {
        String englishText = englishTextArea.getText();
        String morseText = MorseCodeTranslator.englishToMorse(englishText);
        morseTextArea.setText(morseText);
    }

    private void translateToEnglish() {
        String morseText = morseTextArea.getText();
        String englishText = MorseCodeTranslator.morseToEnglish(morseText);
        englishTextArea.setText(englishText);
    }

    // Method to clear both text areas
    private void clearTextAreas() {
        englishTextArea.clear();
        morseTextArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}