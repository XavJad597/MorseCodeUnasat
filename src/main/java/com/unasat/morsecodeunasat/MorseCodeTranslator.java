package com.unasat.morsecodeunasat;

import java.util.HashMap;

public class MorseCodeTranslator {
    private static final HashMap<String, String> englishToMorseLib = new HashMap<>();

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
        return morseCode.toString().trim();
    }

    public static String morseToEnglish(String morseText) {
        StringBuilder englishText = new StringBuilder();
        String[] morseWords = morseText.split(" / ");
        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.split(" ");
            for (String morseChar : morseChars) {
                if (englishToMorseLib.containsKey(morseChar)) {
                    englishText.append(englishToMorseLib.get(morseChar));
                } else if (morseChar.equals("/")) {
                    // Handle word separator
                    englishText.append(" ");
                } else {
                    // Handle unknown Morse code sequences
                    englishText.append("?");
                }
            }
            englishText.append(" "); // Add space between words
        }
        return englishText.toString().trim();
        // Implement Morse to English translation
    }
}
