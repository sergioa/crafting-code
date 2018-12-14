package com.roche.training.craftingcode.businessrules;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearShould {

    @Test
    public void identify_leap_year_if_divisible_by_400() {
        assertTrue(LeapYear.check(400));
        assertTrue(LeapYear.check(800));
    }

    @Test
    public void identify_leap_year_if_divisible_by_4() {
        assertTrue(LeapYear.check(4));
        assertTrue(LeapYear.check(8));

    }

    @Test
    public void identify_leap_year_if_divisible_by_100_and_not_by_400() {
        assertFalse(LeapYear.check(900));
        assertFalse(LeapYear.check(1700));


    }

}