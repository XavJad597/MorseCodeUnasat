package com.unasat.morsecodeunasat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

// Controller class for the Hello World JavaFX application.
// Handles the interaction logic between the user interface (FXML) and the application's data.
public class HelloController {
    
    // Annotation @FXML is used to mark private or protected members of the controller class that are used in FXML,
    // making them accessible to FXML despite the usual Java access control rules.
    
    // The welcomeText label is used to display messages to the user.
    // It is injected by the FXMLLoader, which automatically connects it to the corresponding UI element defined in FXML.
    @FXML
    private Label welcomeText;

    // This method is called when the "Hello" button is clicked.
    // It is connected to the button click event through the FXML file that defines the UI layout.
    @FXML
    protected void onHelloButtonClick() {
        // Sets the text of the welcomeText label to a welcome message.
        // This demonstrates a simple interaction where a UI element is updated in response to user action.
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
