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
  - **Swagger**
  - **JWT**
  - **AOP**
  - **ActiveMQ**

- **Notification Service**:
  - Utilizes **ActiveMQ** for message management. When a new message arrives in the queue, the service automatically sends an EMAIL to users.

## Features

- **User Registration and Authentication**: Users can register, log in, and manage their profiles securely.
- **Schedule Management**: Users can create, read, update, and delete scheduled appointments or events, making it easy to organize their time.
- **Database Interaction**: The application allows users to search for, add, and edit data within the database.
- **Email Notifications**: Users receive email notifications when new messages arrive in the queue, thanks to the integration with ActiveMQ.
- **API Gateway**: The application utilizes an API Gateway to manage requests and responses between the frontend and backend services efficiently.
- **Service Discovery**: With Eureka, the application can dynamically discover and register services, enhancing the overall architecture and scalability.



