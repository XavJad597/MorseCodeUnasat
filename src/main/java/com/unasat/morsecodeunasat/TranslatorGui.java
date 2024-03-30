package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TranslatorGui extends Application {
    private TextArea leftTextArea;
    private TextArea rightTextArea;
    private Button switchButton;

    @Override
    public void start(Stage primaryStage) {
        // Initialize text areas
        leftTextArea = new TextArea();
        leftTextArea.setPromptText("Enter text to translate");
        leftTextArea.setWrapText(true);

        rightTextArea = new TextArea();
        rightTextArea.setPromptText("Translation appears here");
        rightTextArea.setWrapText(true);

        // Initialize switch button
        switchButton = new Button("Switch");
        switchButton.setOnAction(e -> switchText());

        // Initialize translate button
        Button translateButton = new Button("Translate");
        translateButton.setOnAction(e -> translate());

        // Initialize clear button
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearText());

        // Arrange components in VBox
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(leftTextArea, rightTextArea, switchButton, translateButton, clearButton);

        // Set up scene
        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("Translator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void switchText() {
        String temp = leftTextArea.getText();
        leftTextArea.setText(rightTextArea.getText());
        rightTextArea.setText(temp);
    }

    private void translate() {
        String input = leftTextArea.getText().trim();
        String translation = "";

        // Check if input is Morse code or English
        if (isMorse(input)) {
            translation = MorseCodeTranslator.morseToEnglish(input);
        } else {
            translation = MorseCodeTranslator.englishToMorse(input);
        }

        rightTextArea.setText(translation);
    }

    private boolean isMorse(String text) {
        return text.matches("[\\-\\.\\s/]+");
    }

    private void clearText() {
        leftTextArea.clear();
        rightTextArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
