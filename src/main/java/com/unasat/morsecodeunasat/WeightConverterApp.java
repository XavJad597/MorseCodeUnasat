package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeightConverterApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        WeightConverterUI ui = new WeightConverterUI();
        Scene scene = new Scene(ui.getLayout());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weight Converter");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
