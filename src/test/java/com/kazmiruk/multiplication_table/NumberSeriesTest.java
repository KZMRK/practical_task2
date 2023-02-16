package com.kazmiruk.multiplication_table;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberSeriesTest {

    @Test
    void testIntegerFormationOfNumberSeries() {
        NumberSeries<Integer> numberSeries = new NumberSeries<>(Integer.class);
        List<Integer> list = numberSeries.form(1, 10, 3);
        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 4, 7, 10)
        );
        assertEquals(expected, list);
    }

    @Test
    void testDoubleFormationOfNumberSeries() {
        NumberSeries<Double> numberSeries = new NumberSeries<>(Double.class);
        List<Double> list = numberSeries.form(0.5, 2.7, 0.5);
        List<Double> expected = new ArrayList<>(
                Arrays.asList(0.5, 1.0, 1.5, 2.0, 2.5)
        );
        assertEquals(expected, list);
    }
}