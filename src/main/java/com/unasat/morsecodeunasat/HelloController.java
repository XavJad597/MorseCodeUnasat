package com.unasat.morsecodeunasat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
    private TextArea englishTextArea; // Reference to the TextArea for English text input

    @FXML
    private TextArea morseTextArea; // Reference to the TextArea for Morse text output

    @FXML
    private MorseCodeTranslator translator = new MorseCodeTranslator();

    @FXML
    protected void onTranslateToMorseClick() {
        try {
            String englishText = englishTextArea.getText();

            // Call the English to Morse function from the Translator class
            String morseText = translator.englishToMorse(englishText);

            // Set the Morse text to the TextArea for Morse output
            morseTextArea.setText(morseText);
        } catch (NullPointerException e) {
            e.printStackTrace();
            // Handle NullPointerException appropriately
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions appropriately
        }
    }

    @FXML
    protected void onTranslateToEnglishClick() {
        try {
            String morseText = morseTextArea.getText();

            // Call the Morse to English function from the Translator class
            String englishText = translator.morseToEnglish(morseText);

            // Set the English text to the TextArea for English output
            englishTextArea.setText(englishText);
        } catch (NullPointerException e) {
            e.printStackTrace();
            // Handle NullPointerException appropriately
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions appropriately
        }
    }
}
