package com.unasat.morsecodeunasat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea englishTextArea; // Reference to the TextArea for English text input

    @FXML
    private TextArea morseTextArea; // Reference to the TextArea for Morse text output

    @FXML
    private MorseCodeTranslator translator = new MorseCodeTranslator();
    @FXML
    protected void onTranslateToMorseClick() {
        String englishText = englishTextArea.getText();

        // Call the English to Morse function from the Translator class
        String morseText = translator.englishToMorse(englishText);

        // Set the Morse text to the TextArea for Morse output
        morseTextArea.setText(morseText);
    }

    @FXML
    protected void onTranslateToEnglishClick() {
        String morseText = morseTextArea.getText();

        // Call the English to Morse function from the Translator class
        String englishText = translator.morseToEnglish(morseText);

        // Set the Morse text to the TextArea for Morse output
        englishTextArea.setText(englishText);
    }
}