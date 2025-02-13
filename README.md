# Quiz Application

## Overview
The **Quiz Application** is a microservices-based project built using **Spring Boot**, **Spring Cloud Gateway**, and **Eureka Service Discovery**. The application consists of multiple microservices that handle different functionalities such as user management, quiz management, and question handling. The API Gateway routes requests to appropriate services.

**Note:** This project does not have a frontend, and we are using **Postman** for sending API requests.

## Features
- **Microservices Architecture**: Separate services for users, quizzes, and questions.
- **Spring Cloud Gateway**: Acts as an API gateway for routing requests.
- **Eureka Service Discovery**: Enables dynamic discovery of microservices.
- **MongoDB**: Used for storing quiz-related data.
- **Spring Security**: Secure authentication and authorization.
- **OAuth2 Integration**: Supports third-party authentication.

## Tech Stack
- **Backend:** Java 21, Spring Boot 3.4.2, Spring Cloud 2024.0.0
- **Service Discovery:** Eureka Server
- **API Gateway:** Spring Cloud Gateway
- **Database:** MongoDB
- **Authentication:** Spring Security, OAuth2

## Architecture
```
               +----------------------+
               |  API Gateway         |
               |  (Spring Cloud)      |
               +----------------------+
                         |
    --------------------------------------
    |               |                   |
+-----------+  +-----------+  +--------------+
| User      |  | Quiz      |  | Question     |
| Service   |  | Service   |  | Service      |
+-----------+  +-----------+  +--------------+
```

## Installation & Setup
### Prerequisites
- Java 21
- Maven
- MongoDB

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/quiz-application.git
   cd quiz-application
   ```
2. **Start Eureka Server**
   ```sh
   cd service-registry
   mvn spring-boot:run
   ```
3. **Start API Gateway**
   ```sh
   cd api-gateway
   mvn spring-boot:run
   ```
4. **Start Microservices**
   ```sh
   cd user-service
   mvn spring-boot:run
   ```
   ```sh
   cd quiz-service
   mvn spring-boot:run
   ```
   ```sh
   cd question-service
   mvn spring-boot:run
   ```

## API Endpoints
### API Gateway
| Endpoint      | Method | Description       |
|--------------|--------|------------------|
| `/user/**`   | GET    | User Service API |
| `/quiz/**`   | GET    | Quiz Service API |
| `/question/**` | GET  | Question Service API |

## Request Example
After adding the API Gateway, every request should be sent using the API Gateway port. Example:
```
localhost:8555/quiz-service/quiz/get/67ab31f30ab43b4ebc29c14e
```
Here, `quiz-service` is the service name. If another service is used, replace it accordingly.



## Contributing
1. Fork the repository.
2. Create a new branch.
3. Commit your changes.
4. Push the branch.
5. Open a pull request.


