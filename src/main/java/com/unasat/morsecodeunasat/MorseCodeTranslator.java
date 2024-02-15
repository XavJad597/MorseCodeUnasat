package com.unasat.morsecodeunasat;

import java.util.HashMap;

// Class responsible for translating between English text and Morse code.
public class MorseCodeTranslator {
// A static HashMap to hold the mapping between English characters (including numbers and some punctuation) and Morse code.
    private static final HashMap<String, String> englishToMorseLib = new HashMap<>();

    static {
        // Static initializer block to populate the englishToMorseLib map with English to Morse code mappings.
        // Each letter, number, and supported punctuation mark is mapped to its corresponding Morse code representation.
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
    
    // Translates English text to Morse code.
    // Iterates through each character of the input text, converting it to uppercase to match the map keys,
    // and appends the corresponding Morse code to the output string.
    public static String morseToEnglish(String morseText) {
        StringBuilder englishText = new StringBuilder();
        String[] morseWords = morseText.split(" / "); // Split the input text into words based on " / " as the word separator
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
            englishText.append(" "); // Add a space to separate words
        }
        return englishText.toString().trim(); // Return the translated English text, trimming trailing spaces
    }
}
