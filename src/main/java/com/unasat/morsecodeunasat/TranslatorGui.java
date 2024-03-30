package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TranslatorGui extends Application {
    private TextArea englishTextArea;
    private TextArea morseTextArea;

    @Override
    public void start(Stage primaryStage) {
        // Show introduction before starting the main application
        Introduction introduction = new Introduction();
        introduction.setContinueAction(() -> startTranslatorGui(primaryStage));
        introduction.showIntroduction(primaryStage);
    }

    private void startTranslatorGui(Stage primaryStage) {
        // Proceed to the main application
        BorderPane root = new BorderPane();

        englishTextArea = new TextArea();
        morseTextArea = new TextArea();

        Button translateToMorseButton = new Button("Translate to Morse");
        translateToMorseButton.setOnAction(e -> translateToMorse());

        Button translateToEnglishButton = new Button("Translate to English");
        translateToEnglishButton.setOnAction(e -> translateToEnglish());

        root.setLeft(englishTextArea);
        root.setRight(morseTextArea);
        root.setTop(translateToEnglishButton);
        root.setBottom(translateToMorseButton);

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

    public static void main(String[] args) {
        launch(args);
    }
}
