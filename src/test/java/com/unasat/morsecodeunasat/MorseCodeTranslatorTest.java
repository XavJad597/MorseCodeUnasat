package com.unasat.morsecodeunasat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeTranslatorTest {

    @Test
    void englishToMorseTest() {
        //The test cases compare the expected value with the actual results
        String morseResult = MorseCodeTranslator.englishToMorse("HELLO");
        assertEquals(".... . .-.. .-.. ---", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("HELLO WORLD");
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("hello");
        assertEquals(".... . .-.. .-.. ---", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("HeLLo");
        assertEquals(".... . .-.. .-.. ---", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("SORT");
        assertEquals("... --- .-. -", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("SORT BY");
        assertEquals("... --- .-. - / -... -.--", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("sort");
        assertEquals("... --- .-. -", morseResult);

        morseResult = MorseCodeTranslator.englishToMorse("SoRt");
        assertEquals("... --- .-. -", morseResult);
    }

    @Test
    void morseToEnglishTest() {
        String englishResult = MorseCodeTranslator.morseToEnglish(".... . .-.. .-.. ---");
        assertEquals("HELLO", englishResult);

        englishResult = MorseCodeTranslator.morseToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -..");
        assertEquals("HELLO WORLD", englishResult);

        englishResult = MorseCodeTranslator.morseToEnglish(".... . .-.. .-.. --- ????");
        assertEquals("HELLO ??", englishResult);

        englishResult = MorseCodeTranslator.morseToEnglish("... --- .-. -");
        assertEquals("SORT", englishResult);

        englishResult = MorseCodeTranslator.morseToEnglish("... --- .-. - / -... -.--");
        assertEquals("SORT BY", englishResult);
    }
}