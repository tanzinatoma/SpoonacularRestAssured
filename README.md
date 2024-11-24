# SpoonacularRestAssured

### Spoonacular API Test Automation using RestAssured
This repository contains a suite of automated test scripts for the Spoonacular API, implemented using RestAssured and TestNG for API testing. The tests verify the functionality and correctness of various endpoints of the Spoonacular API, which provides recipe and food-related services.

## Project Structure

```css
SpoonacularRestAssured/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── Base.java
│   │   └── resources/
│   │       └── TestData.properties
│   │
│   └── test/
│       ├── java/
│       │   ├── MealPlanningAPITests.java
│       │   └── SearchRecipeAPITests.java
│
├── pom.xml
│
└── README.md
```
## Project Overview
This project uses RestAssured for performing HTTP requests and validating API responses. TestNG is used as the test framework to organize and run tests. The tests ensure that the Spoonacular API behaves as expected by validating response status codes, JSON body content, headers, and other relevant parameters.

### Directory Breakdown
*src/main/java:* Contains the Base.java class, which holds common functionality for all API tests (such as initialization, Response variable, base URL setup), and individual test classes for specific API endpoints.

*src/main/resources:* Contains configuration files and test data, such as TestData.properties (for storing test-related data like API keys).

*src/test/java/tests:* Contains test cases for different Spoonacular API features such as Recipes and Meal Planning.

*pom.xml:* Maven configuration file that includes dependencies for RestAssured, TestNG, and other necessary libraries.
