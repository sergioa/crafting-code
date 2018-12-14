package com.roche.training.craftingcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterShould {

    @Test(expected = RomanNumeralConverterException.class)
    public void fail_when_number_is_negative() throws RomanNumeralConverterException {
        RomanNumeralConverter.convert(-10);
    }

    @Test(expected = RomanNumeralConverterException.class)
    public void fail_when_number_is_zero() throws RomanNumeralConverterException {
        RomanNumeralConverter.convert(0);
    }

    @Test(expected = RomanNumeralConverterException.class)
    public void fail_when_number_is_greater_than_3999() throws RomanNumeralConverterException {
        RomanNumeralConverter.convert(4000);
    }

    @Test
    public void return_the_corresponding_roman_number() throws RomanNumeralConverterException {
        assertEquals(RomanNumeralConverter.convert(3), "III");
        assertEquals(RomanNumeralConverter.convert(8), "VIII");
        assertEquals(RomanNumeralConverter.convert(9), "IX");
        assertEquals(RomanNumeralConverter.convert(99), "XCIX");
        assertEquals(RomanNumeralConverter.convert(4), "IV");
        assertEquals(RomanNumeralConverter.convert(44), "XLIV");
        assertEquals(RomanNumeralConverter.convert(126), "CXXVI");
        assertEquals(RomanNumeralConverter.convert(999), "CMXCIX");
        assertEquals(RomanNumeralConverter.convert(1949), "MCMXLIX");
        assertEquals(RomanNumeralConverter.convert(1206), "MCCVI");
        assertEquals(RomanNumeralConverter.convert(2779), "MMDCCLXXIX");
        assertEquals(RomanNumeralConverter.convert(3888), "MMMDCCCLXXXVIII");
        assertEquals(RomanNumeralConverter.convert(3999), "MMMCMXCIX");
    }

}
