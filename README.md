# E-Commerce Shopping Management System

This project is a shopping management system developed using Spring Boot. It provides a robust foundation for managing an online store with features like handling carts, orders, and products.

## Features
- **Entities:** Includes core entities such as `Cart`, `CartItem`, `Order`, `OrderItem`, and `Product`, with well-defined relationships.
- **Repository Layer:** Handles database interactions seamlessly.
- **Service Layer:** Contains business logic, ensuring separation of concerns.
- **Controller Layer:** Manages RESTful APIs for HTTP requests, enabling operations like adding items to the cart, placing orders, and more.

## Layers Overview
### Repository Layer
The Repository Layer in Spring Boot is responsible for interacting with the database. It abstracts the data access logic and provides methods to perform CRUD (Create, Read, Update, Delete) operations on entities.

### Service Layer
The Service Layer is responsible for business logic. It mediates between the Controller and Repository layers, ensuring that application-specific logic is encapsulated and reusable.

### Controller Layer
The Controller Layer handles HTTP requests and acts as the application entry point. It interacts with the Service Layer to process requests and return responses.

## Technologies Used
- **Framework:** Spring Boot  
- **Database:** MySQL (with HikariCP connection pooling)  
- **API Style:** RESTful  

## How to Run
1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd <repository_folder>
   ```
2. Update `application.properties` with your database configuration.
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
