# LeetCode Practice

A Spring Boot Maven application for solving and practicing LeetCode problems with a RESTful API.

## Project Overview

This project provides a structured approach to solving LeetCode problems with a Spring Boot backend, including:
- RESTful API endpoints for problem solving
- Unit tests for each solution
- Clean code architecture with separation of concerns
- Maven build management

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- Git

## Project Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/com/sranjan/leetcode/
│   │   │   ├── LeetcodeApplication.java
│   │   │   ├── controller/
│   │   │   │   └── SolveController.java
│   │   │   ├── model/
│   │   │   │   ├── ExampleRequest.java
│   │   │   │   └── ExampleResponse.java
│   │   │   └── practice/
│   │   │       └── ExampleProblem.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/sranjan/leetcode/
│           ├── ExampleProblemTest.java
│           └── controller/
│               └── SolveControllerTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## Getting Started

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Run Tests

```bash
mvn test
```

### Run Specific Test

```bash
mvn test -Dtest=ExampleProblemTest
mvn test -Dtest=SolveControllerTest
```

## API Endpoints

### Solve a Problem

**Endpoint:** `POST /api/solve`

**Request Body:**
```json
{
  "problem": "example",
  "input": [1, 2, 3]
}
```

**Response:**
```json
{
  "problem": "example",
  "result": "success",
  "output": 6,
  "executionTime": 0.5
}
```

## Adding New Problems

1. Create a new class in `src/main/java/com/sranjan/leetcode/practice/`
2. Implement the problem solution
3. Create corresponding test class in `src/test/java/com/sranjan/leetcode/`
4. Update the `SolveController` to route to the new problem
5. Run tests to verify the solution

## Example Problem Structure

```java
public class MyProblem {
    public int solve(int[] nums) {
        // Implementation
        return result;
    }
}
```

## Technologies Used

- **Spring Boot 3.2.0** - Web framework
- **Java 17** - Programming language
- **Maven** - Build tool
- **JUnit** - Testing framework

## Contributing

When adding new solutions:
1. Follow Java naming conventions
2. Add comprehensive unit tests
3. Document the solution approach
4. Keep code clean and readable

## License

This project is open source and available under the MIT License.

## Author

Suraj Ranjan (sranjan1)