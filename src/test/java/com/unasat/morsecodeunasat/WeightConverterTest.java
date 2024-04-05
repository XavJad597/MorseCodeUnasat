package com.unasat.morsecodeunasat;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class WeightConverterTest {

    @Test
    public void testPoundToKilogramConversion() {
        assertEquals("Conversion from pounds to kilograms failed.", 4.5359237, WeightConverter.convertPoundsToKilograms(10), 0.0001);
    }

    @Test
    public void testKilogramToPoundConversion() {
        assertEquals("Conversion from kilograms to pounds failed.", 22.0462, WeightConverter.convertKilogramsToPounds(10), 0.0001);
    }
}
