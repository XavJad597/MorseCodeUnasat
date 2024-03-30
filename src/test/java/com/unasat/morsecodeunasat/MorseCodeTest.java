package com.unasat.morsecodeunasat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeTest {

    @Test
    void englishToMorse() {  // Test input and expected output
        String input;
        input = "Hello World";
        String expectedOutput = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";

        // Call the method to be tested
        String actualOutput = MorseCodeTranslator.englishToMorse(input);

        // Assert the expected output with the actual output
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void morseToEnglish() {
    }
}