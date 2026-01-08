package com.sranjan.leetcode.controller;

import com.sranjan.leetcode.model.ExampleRequest;
import com.sranjan.leetcode.model.ExampleResponse;
import com.sranjan.leetcode.practice.ExampleProblem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * REST Controller for solving LeetCode problems.
 * Provides endpoints to solve various LeetCode problems.
 */
@RestController
@RequestMapping("/api/solve")
public class SolveController {

    private static final Logger logger = LoggerFactory.getLogger(SolveController.class);
    private final ExampleProblem exampleProblem = new ExampleProblem();

    /**
 * Solve an example problem.
 * Endpoint: POST /api/solve/example
 *
 * @param request the request containing the problem input
 * @return ResponseEntity with the solution result
 */
    @PostMapping("/example")
    public ResponseEntity<ExampleResponse> solveExample(@Valid @RequestBody ExampleRequest request) {
        logger.info("Received request to solve example problem with input: {}", request);

        try {
            long startTime = System.nanoTime();
            int result = exampleProblem.solve(request.getNumbers());
            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

            ExampleResponse response = new ExampleResponse(
                    "example",
                    "success",
                    result,
                    executionTime
            );

            logger.info("Successfully solved example problem. Result: {}, Execution Time: {}ms", result, executionTime);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error solving example problem", e);
            ExampleResponse errorResponse = new ExampleResponse(
                    "example",
                    "error",
                    null,
                    0.0
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
 * Health check endpoint.
 *
 * @return a simple health check message
 */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("LeetCode Solver is running!");
    }
}