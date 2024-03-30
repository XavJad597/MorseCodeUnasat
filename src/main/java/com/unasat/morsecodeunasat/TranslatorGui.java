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
        //showIntroduction(primaryStage);
      /*  Introduction introduction = new Introduction();
        introduction.showIntroduction(primaryStage);*/

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Introduction introduction = new Introduction();
        introduction.showIntroduction(primaryStage);

        Text introText = new Text("welcome");
        Button continueButton = new Button("Continue");

        continueButton.setOnAction(e -> {
            primaryStage.close();
            // After closing the introduction, start the main application
            startTranslatorGui(primaryStage);
        });

        root.getChildren().addAll(introText, continueButton);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Introduction");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

   /* private void showIntroduction(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Introduction introduction = new Introduction();
        introduction.showIntroduction(primaryStage);

        Text introText = new Text("Welcome to the Morse Translator Application!");
        Button continueButton = new Button("Continue");

        continueButton.setOnAction(e -> {
            primaryStage.close();
            // After closing the introduction, start the main application
            startTranslatorGui(primaryStage);
        });

        root.getChildren().addAll(introText, continueButton);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Introduction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

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

    private void translateToEnglish(){
        String morseText = morseTextArea.getText();
        String englishText = MorseCodeTranslator.morseToEnglish(morseText);
        englishTextArea.setText(englishText);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
