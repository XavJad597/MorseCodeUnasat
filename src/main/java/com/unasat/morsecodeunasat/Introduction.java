package com.unasat.morsecodeunasat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Introduction {

    private Runnable continueAction;

    public void showIntroduction(Stage primaryStage) {
        primaryStage.setTitle("Morse Translator");

        VBox root = new VBox(14);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Text title = createText("Morse Translator", 48);
        Text createdBy = createText("Created by:", 24);

        Text[] creators = {
                createText("Xavier Kiba", 14),
                createText("Joan Koemai", 14),
                createText("Jash Autar", 14),
                createText("Vittorio Midjo", 14),
                createText("Farina Hoepel", 14)
        };

        Text[] emails = {
                createText("x.kiba@unasat.sr", 14),
                createText("j.koemai@unasat.sr", 14),
                createText("j.autar@unasat.sr", 14),
                createText("v.midjo@unasat.sr", 14),
                createText("f.hoepel@unasat.sr", 14)
        };

        Text[] studentNumbers = {
                createText("SE/1122/046", 14),
                createText("SE/1122/109", 14),
                createText("SE/1122/111", 14),
                createText("SE/1121/034", 14),
                createText("SE/1122/032", 14)
        };

        Text[] cohorts = {
                createText("Cohort: 2022", 14),
                createText("Cohort: 2022", 14),
                createText("Cohort: 2022", 14),
                createText("Cohort: 2021", 14),
                createText("Cohort: 2022", 14)
        };


        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        for (int i = 0; i < creators.length; i++) {
            VBox column = new VBox(5);
            column.getChildren().addAll(creators[i], emails[i], studentNumbers[i], cohorts[i]);
            hbox.getChildren().add(column);
        }

        root.getChildren().addAll(title, createdBy, hbox);

        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> {
            primaryStage.close();
            if (continueAction != null) {
                continueAction.run();
            }
        });
        root.getChildren().add(continueButton);

        Scene scene = new Scene(root, 700, 800);
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
