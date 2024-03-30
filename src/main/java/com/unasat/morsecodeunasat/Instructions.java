package com.unasat.morsecodeunasat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Instructions {

        public void showInstructions(Stage primaryStage){

            Button explainButton = new Button("Instructions");
            explainButton.setOnAction( event -> {

                //create instructions window in java
                Stage explainStage = new Stage();
                explainStage.setTitle("Instructions");

                //create the layout and content
                VBox layout = new VBox();
                Label explainLabel = new Label("How to use the translator: " + "\n1. Type your text in the upper Textfield" + "\n2. press on the 'Translate' button ");
                explainLabel.setWrapText(true);
                Button closeButton = new Button();
                closeButton.setOnAction( e -> explainStage.close());
                layout.getChildren().addAll(explainLabel, closeButton);

                Scene scene = new Scene(layout, 300, 200);
                explainStage.setScene(scene);
                explainStage.show();

            });
        }

    }
