package com.sranjan.leetcode.controller;

import com.sranjan.leetcode.model.ExampleRequest;
import com.sranjan.leetcode.model.ExampleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Integration tests for the SolveController.
 * Tests the REST API endpoints.
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("SolveController Tests")
class SolveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // Setup code if needed
    }

    @Test
    @DisplayName("Should solve example problem successfully")
    void testSolveExampleSuccess() throws Exception {
        ExampleRequest request = new ExampleRequest(new int[]{1, 2, 3, 4, 5});

        mockMvc.perform(post("/api/solve/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.problem", equalTo("example")))
                .andExpect(jsonPath("$.status", equalTo("success")))
                .andExpect(jsonPath("$.output", equalTo(15)))
                .andExpect(jsonPath("$.executionTime", greaterThan(0.0)));
    }

    @Test
    @DisplayName("Should return zero for empty array")
    void testSolveExampleEmptyArray() throws Exception {
        ExampleRequest request = new ExampleRequest(new int[]{});

        mockMvc.perform(post("/api/solve/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output", equalTo(0)));
    }

    @Test
    @DisplayName("Should handle negative numbers correctly")
    void testSolveExampleNegativeNumbers() throws Exception {
        ExampleRequest request = new ExampleRequest(new int[]{-5, 10, -3});

        mockMvc.perform(post("/api/solve/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output", equalTo(2)));
    }

    @Test
    @DisplayName("Should return bad request for null numbers")
    void testSolveExampleNullNumbers() throws Exception {
        String jsonRequest = "{\"numbers\": null}";

        mockMvc.perform(post("/api/solve/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should return health status")
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/solve/health")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("LeetCode Solver is running")));
    }
}