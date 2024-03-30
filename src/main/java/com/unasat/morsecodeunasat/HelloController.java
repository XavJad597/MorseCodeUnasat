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