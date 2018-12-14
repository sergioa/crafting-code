package com.roche.training.craftingcode.algorithms;

enum RomanNumber {
    THOUSAND("M", 1000),
    NINE_HUNDREDS("CM", 900),
    FIVE_HUNDREDS("D", 500),
    FOUR_HUNDREDS("CD", 400),
    ONE_HUNDRED("C", 100),
    NINETY("XC", 90),
    FIFTY("L", 50),
    FOURTY("XL", 40),
    TEN("X", 10),
    NINE("IX", 9),
    FIVE("V", 5),
    FOUR("IV", 4);

    private String symbol;
    private int decimal;

    RomanNumber(String symbol, int decimal) {
        this.symbol = symbol;
        this.decimal = decimal;
    }

    public String symbol() {
        return symbol;
    }

    public int decimal() {
        return decimal;
    }
}

public class RomanNumeralConverter {

    private RomanNumeralConverter() {
    }

    public static String convert(final int number) throws RomanNumeralConverterException {
        if (number <= 0 || number > 3999) {
            throw new RomanNumeralConverterException();
        }

        int num = number;
        StringBuilder stringBuilder = new StringBuilder();
        for (RomanNumber romanNumber : RomanNumber.values()) {
            while (num >= romanNumber.decimal()) {
                stringBuilder.append(romanNumber.symbol());
                num -= romanNumber.decimal();
            }
        }

        for (int i = 0; i < num; i++) {
            stringBuilder.append("I");
        }
        return stringBuilder.toString();
    }
}
