package com.unasat.morsecodeunasat;

import java.util.HashMap;
import java.util.logging.Logger;

public class MorseCodeTranslator {
    // A static HashMap to hold the mapping between English characters (including numbers and some punctuation) and Morse code.
    private static final HashMap<String, String> englishToMorseLib = new HashMap<>();
    private static final Logger logger = Logger.getLogger(MorseCodeTranslator.class.getName());

    static {
        // Mapping van de letters naar Morse Code
        englishToMorseLib.put("A", ".-");
        englishToMorseLib.put("B", "-...");
        englishToMorseLib.put("C", "-.-.");
        englishToMorseLib.put("D", "-..");
        englishToMorseLib.put("E", ".");
        englishToMorseLib.put("F", "..-.");
        englishToMorseLib.put("G", "--.");
        englishToMorseLib.put("H", "....");
        englishToMorseLib.put("I", "..");
        englishToMorseLib.put("J", ".---");
        englishToMorseLib.put("K", "-.-");
        englishToMorseLib.put("L", ".-..");
        englishToMorseLib.put("M", "--");
        englishToMorseLib.put("N", "-.");
        englishToMorseLib.put("O", "---");
        englishToMorseLib.put("P", ".--.");
        englishToMorseLib.put("Q", "--.-");
        englishToMorseLib.put("R", ".-.");
        englishToMorseLib.put("S", "...");
        englishToMorseLib.put("T", "-");
        englishToMorseLib.put("U", "..-");
        englishToMorseLib.put("V", "...-");
        englishToMorseLib.put("W", ".--");
        englishToMorseLib.put("X", "-..-");
        englishToMorseLib.put("Y", "-.--");
        englishToMorseLib.put("Z", "--..");

        // getallen
        englishToMorseLib.put("0", "-----");
        englishToMorseLib.put("1", ".----");
        englishToMorseLib.put("2", "..---");
        englishToMorseLib.put("3", "...--");
        englishToMorseLib.put("4", "....-");
        englishToMorseLib.put("5", ".....");
        englishToMorseLib.put("6", "-....");
        englishToMorseLib.put("7", "--...");
        englishToMorseLib.put("8", "---..");
        englishToMorseLib.put("9", "----.");
        //Symbolen
        englishToMorseLib.put(".", ".-.-.-");
        englishToMorseLib.put(",", "--..--");
        englishToMorseLib.put("?", "..--..");
        englishToMorseLib.put(":", "---...");
        englishToMorseLib.put("-", "-....-");
        englishToMorseLib.put("@", ".--.-.");
        englishToMorseLib.put("error", "........");
    }

    public static String englishToMorse(String englishText) {
        StringBuilder morseCode = new StringBuilder();
        try {
            for (char c : englishText.toUpperCase().toCharArray()) {
                // Iterates through each character of the input text, converting it to uppercase to match the map keys,
                if (englishToMorseLib.containsKey(String.valueOf(c))) {
                    morseCode.append(englishToMorseLib.get(String.valueOf(c))).append(" ");
                } else if (c == ' ') {
                    // Handle spaces by adding a slash to separate words in Morse code
                    morseCode.append("/ ");
                } else {
                    // Handle unknown characters or symbols
                    morseCode.append("? ");
                }
            }
        } catch (NullPointerException e) {
            // Handle null input
            System.err.println("Error: Input text is null.");
            return "";
        } catch (Exception e) {
            System.err.println("Error: An unexpected error occurred.");
            e.printStackTrace();
            return "";
        }
        return morseCode.toString().trim();
    }

    // Translates English text to Morse code.
    public static String morseToEnglish(String morseText) {
        StringBuilder englishText = new StringBuilder();
        try {
            String[] morseWords = morseText.split(" / "); // Split the input text into words based on " / " as the word separator
            // Iterates through each character of the input text, converting it to uppercase to match the map keys,
            for (String morseWord : morseWords) {
                String[] morseChars = morseWord.split(" "); // Split each word into individual Morse code sequences
                for (String morseChar : morseChars) {
                    if (englishToMorseLib.containsValue(morseChar)) {
                        // Find the key (English character) for the given Morse code value and append it to the output string
                        englishText.append(englishToMorseLib.entrySet().stream()
                                .filter(entry -> morseChar.equals(entry.getValue()))
                                .map(entry -> entry.getKey())
                                .findFirst().orElse("?"));
                    } else {
                        // Handle unknown Morse code sequences with a question mark
                        englishText.append("?");
                    }
                }
                englishText.append(" ");
            }

        } catch (NullPointerException e) {
            //als er niks word ingevuld
            return "Error: Invalid Morse code input.";
        } catch (IllegalArgumentException e) {
           // geen morse code
            return "Error: Invalid Morse code input.";
        }

        return englishText.toString().trim();
    }

}


