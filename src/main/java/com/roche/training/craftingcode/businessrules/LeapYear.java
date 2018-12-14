package com.roche.training.craftingcode.businessrules;

public class LeapYear {

    private LeapYear() {
    }

    public static boolean check(final int year) {
        return (divisible(year, 400) || divisible(year, 4)) &&
                !(divisible(year, 100) && !divisible(year, 400));
    }

    private static boolean divisible(int number, int mod) {
        return number % mod == 0;
    }
}
