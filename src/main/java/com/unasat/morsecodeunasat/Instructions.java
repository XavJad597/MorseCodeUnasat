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

    public void showInstructions(Stage primaryStage){

        primaryStage.setTitle("Morse Translator");

        VBox root = new VBox(14);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Text title = createText("Morse Translator", 48);
        Text instructionsText = createText("How to use the translator:", 24);

        Text[] instruct = {
                createText("1. Type your text in the upper Textfield", 14),
                createText("2. press on the 'Translate' button", 14),
                createText("Change from English-to-Morse to Morse-to-English", 20),
                createText("Press on the Switch button to change to Morse-to-English",14),
                createText("Deleting the text", 20),
                createText("Press Delete to remove the text.", 14)
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

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setContinueAction(Runnable continueAction) {
        this.continueAction = continueAction;
    }

    private Text createText(String text, double size) {
        Text newText = new Text(text);
        newText.setFont(Font.font(size));
        return newText;
    }
    }
