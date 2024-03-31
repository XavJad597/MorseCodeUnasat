package com.unasat.morsecodeunasat;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MorseCodeTranslator {
    private static final HashMap<String, String> englishToMorseLib = new HashMap<>();
    private static final Logger logger = Logger.getLogger(MorseCodeTranslator.class.getName());


    static {
        // Initialize mapping between English characters and Morse code
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

        englishToMorseLib.put(".", ".-.-.-");
        englishToMorseLib.put(",", "--..--");
        englishToMorseLib.put("?", "..--..");
        englishToMorseLib.put(":", "---...");
        englishToMorseLib.put("-", "-....-");
        englishToMorseLib.put("@", ".--.-.");
        englishToMorseLib.put("error", "........");

        // Other mappings...
    }

    public static String englishToMorse(String englishText) {
        StringBuilder morseCode = new StringBuilder();
        try {
            for (char c : englishText.toUpperCase().toCharArray()) {
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
            // Handle other exceptions
            System.err.println("Error: An unexpected error occurred.");
            e.printStackTrace();
            return "";
        }
        return morseCode.toString().trim();
    }

public static String morseToEnglish(String morseText) {
    StringBuilder englishText = new StringBuilder();

    try {
        // Process Morse code using existing logic
        String[] morseWords = morseText.split(" / ");
        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.split("\\s+"); // Split by any whitespace
            for (String morseChar : morseChars) {
                if (englishToMorseLib.containsValue(morseChar)) {
                    for (Map.Entry<String, String> entry : englishToMorseLib.entrySet()) {
                        if (entry.getValue().equals(morseChar)) {
                            englishText.append(entry.getKey());
                            break; // Once found, break the loop
                        }
                    }
                } else if (morseChar.equals("/")) {
                    englishText.append(" "); // Handle word separator
                } else {
                    englishText.append("? "); // Handle unknown Morse code sequences
                }
            }
            englishText.append(" "); // Add space between words
        }
    } catch (NullPointerException e) {
        return "Error: Invalid Morse code input.";
    } catch (IllegalArgumentException e) {
        logger.log(Level.SEVERE, "Invalid Morse code format. Check separators and characters.", e);
        return "Error: Invalid Morse code input.";
    }

    return englishText.toString().trim();
}

}


