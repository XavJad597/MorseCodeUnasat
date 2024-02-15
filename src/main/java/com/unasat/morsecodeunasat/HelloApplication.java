package com.unasat.morsecodeunasat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Main class for the Morse Code Converter application.
// Extends the Application class from JavaFX to leverage its application lifecycle methods.
public class HelloApplication extends Application {
    
    // The start method is the main entry point for all JavaFX applications.
    // This method is called after the application has been initialized.
    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader is used to load the FXML file that describes the user interface of the application.
        // "hello-view.fxml" defines the layout of the GUI.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        
        // Scene represents the physical contents of a JavaFX application window.
        // The dimensions here set the initial size of the application window to 320x240 pixels.
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        
        // Sets the title of the application window.
        stage.setTitle("Hello world!");
        
        // The scene containing the GUI is applied to the stage.
        stage.setScene(scene);
        
        // Displays the application window on the screen.
        stage.show();
    }

    // The main method serves as the entry point for the application.
    // This is where the launch method is called, which internally calls the start method.
    public static void main(String[] args) {
        // Launches the JavaFX application.
        // This method does not return until the application has exited, either via closing the stage or terminating the application.
        launch();
    }
}
