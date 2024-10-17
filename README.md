# Training Scheduler

## Project Description

This project is a microservices application built using the Spring Boot framework. The application utilizes **Eureka** for service discovery and **ApiGateway** for managing requests between the client and microservices.

## Technologies

The application consists of the following components:

- **Backend**:
  - **Spring Boot**: The core framework for developing microservices.
  - **Spring Data JPA**: For data management and interaction with the database.
  - **MySQL**: As the relational database management system.
  - **Spring Cloud Gateway**: Used as an API Gateway to route requests to the appropriate services.
  - **Eureka**: For automatic discovery and registration of microservices.

- **Notification Service**:
  - Utilizes **ActiveMQ** for message management. When a new message arrives in the queue, the service automatically sends an EMAIL to users.

## Features

- **User Registration and Authentication**: Users can register and log into the application.
- **Database Interaction**: The application allows users to search, add, and edit data.
- **Notifications**: Users receive email notifications when new messages arrive in the queue.


