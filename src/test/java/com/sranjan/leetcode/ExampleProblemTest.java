package com.sranjan.leetcode;

import com.sranjan.leetcode.practice.ExampleProblem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ExampleProblem class.
 * Tests cover various scenarios including edge cases.
 */
@DisplayName("ExampleProblem Tests")
class ExampleProblemTest {

    private ExampleProblem exampleProblem;

    @BeforeEach
    void setUp() {
        exampleProblem = new ExampleProblem();
    }

    @Test
    @DisplayName("Should return correct sum for positive numbers")
    void testSumWithPositiveNumbers() {
        int[] input = {1, 2, 3, 4, 5};
        int expected = 15;
        int result = exampleProblem.solve(input);
        assertEquals(expected, result, "Sum of [1, 2, 3, 4, 5] should be 15");
    }

    @Test
    @DisplayName("Should return zero for empty array")
    void testSumWithEmptyArray() {
        int[] input = {};
        int expected = 0;
        int result = exampleProblem.solve(input);
        assertEquals(expected, result, "Sum of empty array should be 0");
    }

    @Test
    @DisplayName("Should return correct sum for single element")
    void testSumWithSingleElement() {
        int[] input = {42};
        int expected = 42;
        int result = exampleProblem.solve(input);
        assertEquals(expected, result, "Sum of single element [42] should be 42");
    }

    @Test
    @DisplayName("Should return correct sum for negative numbers")
    void testSumWithNegativeNumbers() {
        int[] input = {-1, -2, -3, -4};
        int expected = -10;
        int result = exampleProblem.solve(input);
        assertEquals(expected, result, "Sum of [-1, -2, -3, -4] should be -10");
    }

    @Test
    @DisplayName("Should return correct sum for mixed positive and negative numbers")
    void testSumWithMixedNumbers() {
        int[] input = {-5, 10, -3, 8, 2};
        int expected = 12;
        int result = exampleProblem.solve(input);
        assertEquals(expected, result, "Sum of [-5, 10, -3, 8, 2] should be 12");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for null input")
    void testSumWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> exampleProblem.solve(null),
                "Should throw IllegalArgumentException when input is null");
    }

    @Test
    @DisplayName("Should return correct sum for large numbers")
    void testSumWithLargeNumbers() {
        int[] input = {Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2};
        long result = exampleProblem.solve(input);
        assertEquals(Integer.MAX_VALUE - 1, result, "Should correctly handle large numbers");
    }

    @Test
    @DisplayName("Should return zero for array with zero")
    void testSumWithZero() {
        int[] input = {0};
        int expected = 0;
        int result = exampleProblem.solve(input);
        assertEquals(expected, result, "Sum of [0] should be 0");
    }
}