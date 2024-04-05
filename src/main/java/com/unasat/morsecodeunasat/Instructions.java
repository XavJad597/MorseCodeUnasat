package com.unasat.morsecodeunasat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Instructions {

    private Runnable continueAction;


    //Displays instructions for using the Morse Translator application.
    // Creates a stage with instructions and a "Continue" button.
    public void showInstructions(Stage primaryStage) {

        primaryStage.setTitle("Morse Translator");

        VBox root = new VBox(14);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Text title = createText("Morse Translator", 48);
        Text instructionsText = createText("How to use the translator:", 24);

        Text[] instruct = {
                createText("1. Type your english text/MorseCode in the upper field", 14),
                createText("2.press the translate button to translate the English text/MorseCode", 14),
                createText("3 Press the switch button to switch english text or morse code with eachother", 14),
                createText("Press the 'Clear Text' button to clear the text.", 14)
        };

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        for (int i = 0; i < instruct.length; i++) {
            VBox column = new VBox(5);
            column.getChildren().addAll(instruct[i]);
            vbox.getChildren().add(column);
        }

        root.getChildren().addAll(title, instructionsText, vbox);

        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> {
            primaryStage.close();
            if (continueAction != null) {
                continueAction.run();
            }
        });
        root.getChildren().add(continueButton);

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //this method let's you continue to the next window with a button.
    public void setContinueAction(Runnable continueAction) {
        this.continueAction = continueAction;
    }


    //This method creates and returns a JavaFX Text object with the specified text content and font size.
    private Text createText(String text, double size) {
        Text newText = new Text(text);
        newText.setFont(Font.font(size));
        return newText;
    }
}
