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
import com.unasat.morsecodeunasat.MorseCodeTranslator;

// Main class for the GUI of the Morse Code Translator application.
// Extends Application to use JavaFX for building the user interface.
public class TranslatorGui extends Application {
    Instructions instructions = new Instructions();
    private TextArea leftTextArea;
    private TextArea rightTextArea;
    private Button switchButton;


    @Override
    public void start(Stage primaryStage) {
        // Show introduction before starting the main application
        Introduction introduction = new Introduction();
        introduction.setContinueAction(() -> startTranslatorGui(primaryStage));
        introduction.showIntroduction(primaryStage);
    }

   /* public void instruction(Stage primaryStage) {
        instructions.setContinueAction(() -> startTranslatorGui(primaryStage));
        instructions.showInstructions(primaryStage);
    }*/

    private void startTranslatorGui(Stage primaryStage) {
        // Proceed to the main application
        BorderPane root = new BorderPane();
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

        //help button
        Button helpButton = new Button ("help");
        helpButton.setOnAction(e-> instructions.showInstructions(primaryStage, this));

        // Arrange components in VBox
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(leftTextArea, rightTextArea, switchButton, translateButton, clearButton,helpButton);


        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("Translator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void returnToTranslator(Stage primaryStage) {
        startTranslatorGui(primaryStage); // Call the method to start the translator GUI again
    }

    private void switchText() {
        String temp = leftTextArea.getText();
        leftTextArea.setText(rightTextArea.getText());
        rightTextArea.setText(temp);
    }

    private void translate() {
        String input = leftTextArea.getText().trim();
        String translation = "";

        // Create an instance of MorseCodeTranslator
        MorseCodeTranslator translator = new MorseCodeTranslator();

        // Check if input is Morse code or English
        if (isMorse(input)) {
            // Translate Morse code to English
            StringBuilder englishText = new StringBuilder();
            String[] morseWords = input.split("\\s+/\\s+");
            for (String morseWord : morseWords) {
                String[] morseChars = morseWord.split("\\s+");
                for (String morseChar : morseChars) {
                    englishText.append(translator.morse2abc(morseChar));
                }
                englishText.append(" ");
            }
            translation = englishText.toString().trim();
        } else {
            // Translate English to Morse code
            StringBuilder morseText = new StringBuilder();
            for (char c : input.toCharArray()) {
                morseText.append(translator.abs2morse(c)).append(" ");
            }
            translation = morseText.toString().trim();
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

    // Method to translate English text to Morse code and display the result.
    public static void main(String[] args) {
        launch(args);
    }
}
