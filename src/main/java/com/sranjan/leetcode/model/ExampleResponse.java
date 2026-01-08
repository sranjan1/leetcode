package com.sranjan.leetcode.model;

/**
 * Response model for LeetCode problem output.
 * Contains the result and metadata of solving a problem.
 */
public class ExampleResponse {

    private String problem;
    private String status;
    private Integer output;
    private Double executionTime;

    /**
     * Default constructor.
     */
    public ExampleResponse() {
    }

    /**
     * Constructor with all parameters.
     *
     * @param problem the problem name
     * @param status the execution status
     * @param output the solution output
     * @param executionTime the execution time in milliseconds
     */
    public ExampleResponse(String problem, String status, Integer output, Double executionTime) {
        this.problem = problem;
        this.status = status;
        this.output = output;
        this.executionTime = executionTime;
    }

    /**
     * Get the problem name.
     *
     * @return the problem name
     */
    public String getProblem() {
        return problem;
    }

    /**
     * Set the problem name.
     *
     * @param problem the problem name to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * Get the execution status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the execution status.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the solution output.
     *
     * @return the output
     */
    public Integer getOutput() {
        return output;
    }

    /**
     * Set the solution output.
     *
     * @param output the output to set
     */
    public void setOutput(Integer output) {
        this.output = output;
    }

    /**
     * Get the execution time.
     *
     * @return the execution time in milliseconds
     */
    public Double getExecutionTime() {
        return executionTime;
    }

    /**
     * Set the execution time.
     *
     * @param executionTime the execution time to set
     */
    public void setExecutionTime(Double executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return "ExampleResponse{" +
                "problem='" + problem + '\'' +
                ", status='" + status + '\'' +
                ", output=" + output +
                ", executionTime=" + executionTime +
                '}';
    }
}