# Janitri Backend Assignment

## Overview

This is a backend development project for Janitri, focusing on monitoring patient heart rate data. The project is developed using Spring Boot and exposes RESTful APIs to manage users, patients, and their heart rate data.

## Requirements

- **Java 11+** for the backend development.
- **Spring Boot** as the framework for building the application.
- **H2 Database** for local in-memory data storage.
- **Postman** (or any REST API testing tool) to test the endpoints.

## Assumptions & Decisions

- **Database**: In-memory MySQL database has been used for simplicity. For production, you can replace it with a relational database like MySQL or PostgreSQL.
- **Validation**: Basic input validation is implemented using annotations like `@NotNull`, `@Size`, and custom validation messages.
- **Security**: No advanced security (such as OAuth2 or JWT) is used, as per the project instructions. Simple login validation is implemented.
- **Error Handling**: Global exception handling is implemented to catch validation errors and general exceptions.
- **API Documentation**: All the required API endpoints are documented below.

## Setting up the Project

### Prerequisites

- **Java 11 or later**: Ensure that Java is installed on your system.
- **Maven**: This project uses Maven for dependency management. You can download it from [here](https://maven.apache.org/download.cgi) or use it through an IDE like IntelliJ or Eclipse.

### Steps to run the project

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Rudrakumarpatel/Janitri-Backend-Assignment.git
   ```

Navigate to the project directory:
cd Janitri-Backend-Assignment

Build the project using Maven:
mvn clean install

Run the application:

mvn spring-boot:run

The application will run on http://localhost:8080.

Running Tests

You can run the tests using Maven:
mvn test

# API Documentation for Janitri Backend

This document provides the details of all the API endpoints used in the Janitri Backend project for managing users, patients, and heart rate data.

## Base URL

The base URL for all API requests is:  
`http://localhost:8080/api`

---

## 1. **User Registration API**

- **Endpoint**: `/users/register`
- **Method**: `POST`
- **Description**: Registers a new user.
- **Request Body**:
  ```json
  {
    "email": "user@example.com",
    "password": "password123"
  }
  ```
- **Response**:
  - **200 OK**:
  ```json
  {
    "message": "User registered successfully"
  }
  ```
  - **400 Bad Request**: If email already exists or validation fails.
  ```json
  {
    "email": "Email already exists"
  }
  ```

---

## 2. **User Login API**

- **Endpoint**: `/users/login`
- **Method**: `POST`
- **Description**: Logs in the user by validating email and password.
- **Request Body**:
  ```json
  {
    "email": "user@example.com",
    "password": "password123"
  }
  ```
- **Response**:
  - **200 OK**: If login is successful.
  ```json
  {
    "message": "Login successful"
  }
  ```
  - **401 Unauthorized**: If the credentials are invalid.
  ```json
  {
    "message": "Invalid credentials"
  }
  ```

---

## 3. **Add Patient API**

- **Endpoint**: `/patients/add`
- **Method**: `POST`
- **Description**: Adds a new patient.
- **Request Body**:
  ```json
  {
    "name": "Rudrakumar Patel",
    "age": 21,
    "address": "ABCD",
    "gender": "Male"
  }
  ```
- **Response**:
  - **200 OK**: If patient is added successfully.
  ```json
  {
    "message": "Patient added successfully"
  }
  ```
  - **400 Bad Request**: If required fields are missing or invalid.
  ```json
  {
    "error": "Validation errors"
  }
  ```

---

## 4. **Get Patient Details API**

- **Endpoint**: `/patients/{id}`
- **Method**: `GET`
- **Description**: Fetches details of a specific patient by ID.
- **Response**:
  - **200 OK**: If the patient exists.
  ```json
  {
    "id": 1,
    "name": "Rudrakumar Patel",
    "age": 21,
    "address": "ABCD",
    "gender": "Male"
  }
  ```
  - **404 Not Found**: If the patient does not exist.
  ```json
  {
    "message": "Patient not found"
  }
  ```
  **Endpoint**: `/patients`
- **Method**: `GET`
- **Description**: Fetches details of a all patients.
- **Response**:
  - **200 OK**: If the patient exists.
  ```json
  [
    {
        "id": 1,
        "name": "Patient A",
        "age": 30,
        "address": "119,abc society",
        "gender": ""
    },
    {
        "id": 2,
        "name": "Patient B",
        "age": 21,
        "address": "11,abc society",
        "gender": ""
    },
    {
        "id": 3,
        "name": "Rudrakumar Patel",
        "age": 20,
        "address": "abc, xyz",
        "gender": ""
    },
    {
        "id": 4,
        "name": "ABCD",
        "age": 0,
        "address": null,
        "gender": ""
    }
  ]
---

## 5. **Record Heart Rate API**

- **Endpoint**: `/heart-rates/add`
- **Method**: `POST`
- **Description**: Records the heart rate data for a patient.
- **Request Body**:
  ```json
  {
    "patientId": 1,
    "bpm": 75
  }
  ```
- **Response**:
  - **200 OK**: If heart rate data is recorded successfully.
  ```json
  
  {
    "id": 7,
    "patient": {
        "id": 4,
        "name": "Rudrakumar Patel",
        "age": 21,
        "address": "ABCD",
        "gender": "Male"
    },
    "bpm": 75,
    "recordedAt": null
  }

  ```
  - **400 Bad Request**: If the patient ID is invalid or bpm is not provided.
  ```json
  {
    "message": "Patient not found"
  }
  {
    "bpm": "Please Enter Valid bpm (at Least 30)"
  }
  ```

---

## 6. **Get Heart Rate Data API**

- **Endpoint**: `/heart-rates/{patientId}`
- **Method**: `GET`
- **Description**: Retrieves the heart rate records for a specific patient.
- **Response**:
  - **200 OK**: If heart rate data exists.
  ```json
  [
    {
        "id": 7,
        "patient": {
            "id": 4,
            "name": "Rudrakumar Patel",
            "age": 21,
            "address": "ABCD",
            "gender": "Male"
        },
        "bpm": 75,
        "recordedAt": null
    }
  ]
  ```
  - **404 Not Found**: If no heart rate data exists for the given patient.
  ```json
  {
    "message": []
  }
  ```
  **404 Not Found**: If no Patient data exists.
  ```json
  {
    "message": "Patient not found"
  }

  **Endpoint**: `/heart-rates/all`
- **Method**: `GET`
- **Description**: Retrieves all the heart rate records for a patients.
- **Response**:
  - **200 OK**: If heart rate data exists.
  ```json
  [
    {
        "id": 1,
        "patient": {
            "id": 1,
            "name": "Patient A",
            "age": 30,
            "address": "119,abc society",
            "gender": ""
        },
        "bpm": 75,
        "recordedAt": "2025-02-13T14:00:00"
    },
    {
        "id": 2,
        "patient": {
            "id": 1,
            "name": "Patient A",
            "age": 30,
            "address": "119,abc society",
            "gender": ""
        },
        "bpm": 75,
        "recordedAt": "2025-02-13T14:00:00"
    },
    {
        "id": 3,
        "patient": {
            "id": 2,
            "name": "Patient B",
            "age": 21,
            "address": "11,abc society",
            "gender": ""
        },
        "bpm": 75,
        "recordedAt": "2025-02-13T14:00:00"
    },
    {
        "id": 4,
        "patient": {
            "id": 3,
            "name": "Rudrakumar Patel",
            "age": 20,
            "address": "abc, xyz",
            "gender": ""
        },
        "bpm": 70,
        "recordedAt": "2025-02-13T14:00:00"
    },
    {
        "id": 5,
        "patient": {
            "id": 3,
            "name": "Rudrakumar Patel",
            "age": 20,
            "address": "abc, xyz",
            "gender": ""
        },
        "bpm": 76,
        "recordedAt": "2025-02-13T14:00:00"
    }
  ]

---

## Error Handling

The API returns appropriate HTTP status codes with error messages for invalid requests:

- **400 Bad Request**: Invalid input or missing required fields in the request body.
- **401 Unauthorized**: Invalid user credentials during login.
- **404 Not Found**: When a resource (patient or heart rate data) is not found.
- **500 Internal Server Error**: For general internal server issues.

---

## Global Exception Handling

The project includes global exception handling for validation and other errors. It returns user-friendly error messages with relevant HTTP status codes.

For example:

- If any required field is missing or invalid, the `400 Bad Request` status is returned with specific error details.
- General errors are handled with `500 Internal Server Error` and a message describing the issue.

---

## Notes

- **Security**: No advanced security mechanisms (like JWT) are implemented as per the requirements.
- **Database**: In-memory H2 database is used. You can replace it with MySQL or PostgreSQL for production environments.
- **Validation**: Basic validation is done using annotations like `@NotNull`, `@Size`, and custom error messages for better user experience.
- **Testing**: Use Postman or any API client to test the endpoints. Refer to the request and response examples above.

---
