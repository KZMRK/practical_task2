package com.kazmiruk.multiplication_table;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    void testMultiplyInteger() {
        Multiplication<Integer> multiplication = new Multiplication<>(Integer.class);

        List<Integer> firstMultipliers = new ArrayList<>(
                Arrays.asList(1, 3, 5, 7)
        );
        List<Integer> secondMultipliers = new ArrayList<>(firstMultipliers);

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 3, 5, 7),
                        Arrays.asList(3, 9, 15, 21),
                        Arrays.asList(5, 15, 25, 35),
                        Arrays.asList(7, 21, 35, 49)
                )
        );
        assertEquals(expected, multiplication.multiply(firstMultipliers, secondMultipliers));
    }

    @Test
    void testMultiplyDouble() {
        Multiplication<Double> multiplication = new Multiplication<>(Double.class);

        List<Double> firstMultipliers = new ArrayList<>(
                Arrays.asList(0.4, 0.7, 2.0, 2.3)
        );
        List<Double> secondMultipliers = new ArrayList<>(firstMultipliers);

        List<List<Double>> expected = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(0.4 * 0.4, 0.4 * 0.7, 0.4 * 2.0, 0.4 * 2.3),
                        Arrays.asList(0.7 * 0.4, 0.7 * 0.7, 0.7 * 2, 0.7 * 2.3),
                        Arrays.asList(2.0 * 0.4, 2.0 * 0.7, 2.0 * 2.0, 2.0 * 2.3),
                        Arrays.asList(2.3 * 0.4, 2.3 * 0.7, 2.3 * 2.0, 2.3 * 2.3)
                )
        );
        assertEquals(expected, multiplication.multiply(firstMultipliers, secondMultipliers));
    }
}