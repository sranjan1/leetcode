package com.sranjan.leetcode.practice;

/**
 * Example problem: Sum of an array.
 * 
 * This is a simple example problem that sums all numbers in an array.
 * This problem demonstrates the basic structure of a LeetCode problem solution.
 *
 * Problem Statement:
 * Given an array of integers, return the sum of all numbers in the array.
 *
 * Example:
 * Input: [1, 2, 3, 4, 5]
 * Output: 15
 *
 * Time Complexity: O(n) where n is the number of elements
 * Space Complexity: O(1) constant space
 */
public class ExampleProblem {

    /**
     * Solves the sum of array problem.
     *
     * @param numbers the input array of integers
     * @return the sum of all numbers in the array
     * @throws IllegalArgumentException if the input array is null
     */
    public int solve(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}