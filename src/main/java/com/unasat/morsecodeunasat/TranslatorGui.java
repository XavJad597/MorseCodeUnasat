package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Main class for the GUI of the Morse Code Translator application.
// Extends Application to use JavaFX for building the user interface.
public class TranslatorGui extends Application {
    // Text areas for input and output: one for English text and one for Morse code.
    private TextArea englishTextArea;
    private TextArea morseTextArea;

    @Override
    // The start method is the entry point for JavaFX applications.
    public void start(Stage primaryStage) {
        // BorderPane is used as the root layout for this application. It allows placing components in the top, bottom, left, right, and center.
        BorderPane root = new BorderPane();

        // Initialize text areas for English and Morse code input/output.
        englishTextArea = new TextArea();
        morseTextArea = new TextArea();

        // Button to trigger translation from English to Morse code.
        Button translateToMorseButton = new Button("Translate to Morse");
        // Set the action to be performed when the button is clicked.
        translateToMorseButton.setOnAction(e -> translateToMorse());

        // Button to trigger translation from Morse code to English.
        Button translateToEnglishButton = new Button("Translate to English");
        // Corrected: Set the action for the translateToEnglishButton instead of setting it again for translateToMorseButton.
        translateToEnglishButton.setOnAction(e -> translateToEnglish());

        // Layout configuration: English text area on the left, Morse code text area on the right.
        root.setLeft(englishTextArea);
        root.setRight(morseTextArea);
        // Place translation buttons at the top and bottom of the UI.
        root.setTop(translateToEnglishButton);
        root.setBottom(translateToMorseButton);

        // Create the scene with the specified root layout and dimensions.
        Scene scene = new Scene(root, 600, 400);
        // Set the title of the primary stage (application window).
        primaryStage.setTitle("Morse Translator");
        // Apply the scene to the primary stage and display it.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to translate English text to Morse code and display the result.
    private void translateToMorse() {
        // Get the English text from the text area.
        String englishText = englishTextArea.getText();
        // Translate to Morse code using the MorseCodeTranslator class.
        String morseText = MorseCodeTranslator.englishToMorse(englishText);
        // Display the Morse code in the morse text area.
        morseTextArea.setText(morseText);
    }

    // Method to translate Morse code to English and display the result.
    private void translateToEnglish() {
        // Get the Morse code text from the text area.
        String morseText = morseTextArea.getText();
        // Translate to English using the MorseCodeTranslator class.
        String englishText = MorseCodeTranslator.morseToEnglish(morseText);
        // Display the English text in the english text area.
        englishTextArea.setText(englishText);
    }

    // Main method to launch the application.
    public static void main(String[] args) {
        launch(args);
    }
}
