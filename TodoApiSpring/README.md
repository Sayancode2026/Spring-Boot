# TodoApiSpring – Spring Boot REST API

A beginner-friendly **Spring Boot REST API** project implementing a Todo Management service with CRUD operations using in-memory storage. This project demonstrates RESTful API development, HTTP methods, request/response handling, and Spring Boot fundamentals.

> Built as part of my Spring Boot backend learning journey.

## Features

* Retrieve all todos (`GET`)
* Retrieve a todo by ID (`GET`)
* Create a new todo (`POST`)
* Update specific fields using `PATCH`
* Delete a todo (`DELETE`)
* RESTful API design with proper HTTP status codes
* JSON request and response handling using Spring Boot

## Tech Stack

| Technology    | Version     |
| ------------- | ----------- |
| Java          | 21          |
| Spring Boot   | 3.x         |
| Gradle        | Latest      |
| REST APIs     | HTTP/JSON   |
| IntelliJ IDEA | Development |

## Project Structure

```
TodoApiSpring/
├── src/
│   ├── main/
│   │   ├── java/org/example/todoapispring/
│   │   │   ├── Todo.java
│   │   │   ├── TodoController.java
│   │   │   ├── TodoPatchRequest.java
│   │   │   └── TodoApiSpringApplication.java
│   │   └── resources/
├── build.gradle
├── settings.gradle
└── README.md
```

## API Endpoints

Base URL

```
/api/v1/todos
```

| Method | Endpoint    | Description            |
| ------ | ----------- | ---------------------- |
| GET    | `/`         | Get all todos          |
| GET    | `/{todoId}` | Get a todo by ID       |
| POST   | `/`         | Create a new todo      |
| PATCH  | `/{todoId}` | Update specific fields |
| DELETE | `/{todoId}` | Delete a todo          |

## Sample Requests

### Get All Todos

```http
GET /api/v1/todos/
```

Response

```json
[
  {
    "id": 1,
    "completed": false,
    "title": "Todo 1",
    "userId": 1000
  }
]
```

### Create Todo

```http
POST /api/v1/todos/
Content-Type: application/json
```

```json
{
  "id": 3,
  "completed": false,
  "title": "Learn Spring Boot",
  "userId": 1002
}
```

Response

```http
201 Created
```

### Update Todo

```http
PATCH /api/v1/todos/1
Content-Type: application/json
```

```json
{
  "title": "Master Spring Boot",
  "completed": true
}
```

### Delete Todo

```http
DELETE /api/v1/todos/2
```

Response

```http
204 No Content
```

## HTTP Status Codes Used

| Status | Meaning    |
| ------ | ---------- |
| 200    | OK         |
| 201    | Created    |
| 204    | No Content |
| 404    | Not Found  |

## How to Run

### Clone

```bash
git clone https://github.com/Sayancode2026/Spring-Boot.git
```

Navigate to the project

```bash
cd Spring-Boot/TodoApiSpring
```

Run the application

```bash
./gradlew bootRun
```

Windows

```bash
gradlew.bat bootRun
```

The application starts on

```
http://localhost:8080
```

## Learning

* Spring Boot project structure
* REST Controller development
* Request Mapping (`@GetMapping`, `@PostMapping`, `@PatchMapping`, `@DeleteMapping`)
* `ResponseEntity` and HTTP status handling
* `@RequestBody` and `@PathVariable`
* JSON serialization and deserialization
* Designing REST API contracts

## Future Improvements

* Connect PostgreSQL using Spring Data JPA
* Add Service and Repository layers
* Request validation (`@Valid`)
* Global exception handling
* Swagger/OpenAPI documentation
* JWT Authentication
* Unit testing with JUnit and Mockito
