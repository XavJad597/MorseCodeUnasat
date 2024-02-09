 package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TranslatorGui extends Application {
    private TextArea englishTextArea;
    private TextArea morseTextArea;

    @Override

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        englishTextArea = new TextArea();
        morseTextArea = new TextArea();

        Button translateToMorseButton = new Button("Translate to Morse");
        translateToMorseButton.setOnAction(e -> translateToMorse());

        Button translateToEnglishButton = new Button("Translate to english");
        translateToMorseButton.setOnAction(e -> {
            translateToEnglish();
        });

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

    private void translateToEnglish(){
        String morseText = morseTextArea.getText() ;

        String englishText = MorseCodeTranslator.morseToEnglish(morseText);
        englishTextArea.setText(englishText);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
