package com.unasat.morsecodeunasat;

public class WeightConverter {
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.45359237;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms / 0.45359237;
    }
}
