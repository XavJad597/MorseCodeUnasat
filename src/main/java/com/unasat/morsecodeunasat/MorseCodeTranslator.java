package com.unasat.morsecodeunasat;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.HashMap;
import javafx.stage.Stage;

public class MorseCodeTranslator implements Requirements.pierRequirements {

    private String translation;
    // Define Morse code mappings
    private static final HashMap<Character, String> charToMorse = new HashMap<>();
    private static final HashMap<String, Character> morseToChar = new HashMap<>();

    static {
        // Populate Morse code mappings
        charToMorse.put('A', ".-");
        charToMorse.put('B', "-...");
        charToMorse.put('C', "-.-.");
        charToMorse.put('D', "-..");
        charToMorse.put('E', ".");
        charToMorse.put('F', "..-.");
        charToMorse.put('G', "--.");
        charToMorse.put('H', "....");
        charToMorse.put('I', "..");
        charToMorse.put('J', ".---");
        charToMorse.put('K', "-.-");
        charToMorse.put('L', ".-..");
        charToMorse.put('M', "--");
        charToMorse.put('N', "-.");
        charToMorse.put('O', "---");
        charToMorse.put('P', ".--.");
        charToMorse.put('Q', "--.-");
        charToMorse.put('R', ".-.");
        charToMorse.put('S', "...");
        charToMorse.put('T', "-");
        charToMorse.put('U', "..-");
        charToMorse.put('V', "...-");
        charToMorse.put('W', ".--");
        charToMorse.put('X', "-..-");
        charToMorse.put('Y', "-.--");
        charToMorse.put('Z', "--..");

        // getallen
        charToMorse.put('0', "-----");
        charToMorse.put('1', ".----");
        charToMorse.put('2', "..---");
        charToMorse.put('3', "...--");
        charToMorse.put('4', "....-");
        charToMorse.put('5', ".....");
        charToMorse.put('6', "-....");
        charToMorse.put('7', "--...");
        charToMorse.put('8', "---..");
        charToMorse.put('9', "----.");
        //Symbolen
        charToMorse.put('.', ".-.-.-");
        charToMorse.put(',', "--..--");
        charToMorse.put('?', "..--..");
        charToMorse.put(':', "---...");
        charToMorse.put('-', "-....-");
        charToMorse.put('@', ".--.-.");


        // Populate reverse Morse code mappings
        for (Character key : charToMorse.keySet()) {
            morseToChar.put(charToMorse.get(key), key);
        }
    }



    @Override
    public String[] groepsleden() {
        // Return an array of group member names
        return new String[]{"Xavier Kiba", "Farina Hoepel", "Jash Autar", "Joan Koemai", "Vittorio Midjo"};
    }


    @Override
    public String abs2morse(char inputChar) {
        try {
            // Convert character to Morse code
            return charToMorse.getOrDefault(Character.toUpperCase(inputChar), "");
        } catch (Exception e) {
            // Handle any exception that may occur
            System.err.println("An error occurred while converting character to Morse code: " + e.getMessage());
            return ""; // Return an empty string or handle the exception according to your requirements
        }
    }


    @Override
    public char morse2abc(String inputString) {
        try {
            // Convert Morse code to character
            return morseToChar.getOrDefault(inputString, ' ');
        } catch (Exception e) {
            // Handle any exception that may occur
            System.err.println("An error occurred while converting Morse code to character: " + e.getMessage());
            return ' '; // Return a default character or handle the exception according to your requirements
        }
    }


    @Override
    public void convert() {
        // Implementation of conversion based on user input
        // This method's implementation would depend on the specific requiremen

    }


    @Override
    public void swap() {
        // Implementation of swapping data between input and output fields
        // This method's implementation would depend on the specific requirements
    }

    @Override
    public void clear() {

        // Implementation of clearing input and output data
        // This method's implementation would depend on the specific requirements
    }

    @Override
    public String exampleMorseCode() {
        // Return an example input for Morse code
        return ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
    }

    @Override
    public String exampleString() {
        // Return an example input for conversion
        return "HELLO WORLD";
    }
    private Runnable continueAction;

    @Override
    public String explain() {
        return "This class provides methods for converting characters to Morse code and vice versa.";
    }
}

//public class MorseCodeTranslator {
//    // A static HashMap to hold the mapping between English characters (including numbers and some punctuation) and Morse code.
//    private static final HashMap<String, String> charToMorse = new HashMap<>();
//    private static final Logger logger = Logger.getLogger(MorseCodeTranslator.class.getName());
//
//    static {
//        // Mapping van de letters naar Morse Code
//        charToMorse.put("A", ".-");
//        charToMorse.put("B", "-...");
//        charToMorse.put("C", "-.-.");
//        charToMorse.put("D", "-..");
//        charToMorse.put("E", ".");
//        charToMorse.put("F", "..-.");
//        charToMorse.put("G", "--.");
//        charToMorse.put("H", "....");
//        charToMorse.put("I", "..");
//        charToMorse.put("J", ".---");
//        charToMorse.put("K", "-.-");
//        charToMorse.put("L", ".-..");
//        charToMorse.put("M", "--");
//        charToMorse.put("N", "-.");
//        charToMorse.put("O", "---");
//        charToMorse.put("P", ".--.");
//        charToMorse.put("Q", "--.-");
//        charToMorse.put("R", ".-.");
//        charToMorse.put("S", "...");
//        charToMorse.put("T", "-");
//        charToMorse.put("U", "..-");
//        charToMorse.put("V", "...-");
//        charToMorse.put("W", ".--");
//        charToMorse.put("X", "-..-");
//        charToMorse.put("Y", "-.--");
//        charToMorse.put("Z", "--..");
//
//        // getallen
//        charToMorse.put("0", "-----");
//        charToMorse.put("1", ".----");
//        charToMorse.put("2", "..---");
//        charToMorse.put("3", "...--");
//        charToMorse.put("4", "....-");
//        charToMorse.put("5", ".....");
//        charToMorse.put("6", "-....");
//        charToMorse.put("7", "--...");
//        charToMorse.put("8", "---..");
//        charToMorse.put("9", "----.");
//        //Symbolen
//        charToMorse.put(".", ".-.-.-");
//        charToMorse.put(",", "--..--");
//        charToMorse.put("?", "..--..");
//        charToMorse.put(":", "---...");
//        charToMorse.put("-", "-....-");
//        charToMorse.put("@", ".--.-.");
//        charToMorse.put("error", "........");
//    }
//
//    public static String abs2morse(String englishText) {
//        StringBuilder morseCode = new StringBuilder();
//        try {
//            for (char c : englishText.toUpperCase().toCharArray()) {
//                // Iterates through each character of the input text, converting it to uppercase to match the map keys,
//                if (charToMorse.containsKey(String.valueOf(c))) {
//                    morseCode.append(charToMorse.get(String.valueOf(c))).append(" ");
//                } else if (c == ' ') {
//                    // Handle spaces by adding a slash to separate words in Morse code
//                    morseCode.append("/ ");
//                } else {
//                    // Handle unknown characters or symbols
//                    morseCode.append("? ");
//                }
//            }
//        } catch (NullPointerException e) {
//            // Handle null input
//            System.err.println("Error: Input text is null.");
//            return "";
//        } catch (Exception e) {
//            System.err.println("Error: An unexpected error occurred.");
//            e.printStackTrace();
//            return "";
//        }
//        return morseCode.toString().trim();
//    }
//
//    // Translates English text to Morse code.
//    public static String morse2abc(String morseText) {
//        StringBuilder englishText = new StringBuilder();
//        try {
//            String[] morseWords = morseText.split(" / "); // Split the input text into words based on " / " as the word separator
//            // Iterates through each character of the input text, converting it to uppercase to match the map keys,
//            for (String morseWord : morseWords) {
//                String[] morseChars = morseWord.split(" "); // Split each word into individual Morse code sequences
//                for (String morseChar : morseChars) {
//                    if (charToMorse.containsValue(morseChar)) {
//                        // Find the key (English character) for the given Morse code value and append it to the output string
//                        englishText.append(charToMorse.entrySet().stream()
//                                .filter(entry -> morseChar.equals(entry.getValue()))
//                                .map(entry -> entry.getKey())
//                                .findFirst().orElse("?"));
//                    } else {
//                        // Handle unknown Morse code sequences with a question mark
//                        englishText.append("?");
//                    }
//                }
//                englishText.append(" ");
//            }
//
//        } catch (NullPointerException e) {
//            //als er niks word ingevuld
//            return "Error: Invalid Morse code input.";
//        } catch (IllegalArgumentException e) {
//           // geen morse code
//            return "Error: Invalid Morse code input.";
//        }
//
//        return englishText.toString().trim();
//    }
//
//}
//
//
