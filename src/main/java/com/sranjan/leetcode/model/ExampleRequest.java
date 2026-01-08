package com.sranjan.leetcode.model;

import jakarta.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * Request model for LeetCode problem input.
 * Contains the input data for solving a problem.
 */
public class ExampleRequest {

    @NotNull(message = "Numbers array cannot be null")
    private int[] numbers;

    /**
     * Default constructor.
     */
    public ExampleRequest() {
    }

    /**
     * Constructor with numbers parameter.
     *
     * @param numbers the input array of numbers
     */
    public ExampleRequest(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Get the numbers array.
     *
     * @return the numbers array
     */
    public int[] getNumbers() {
        return numbers;
    }

    /**
     * Set the numbers array.
     *
     * @param numbers the numbers array to set
     */
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "ExampleRequest{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}