# E-Commerce Shopping Management System

This project is a shopping management system developed using Spring Boot. It provides a robust foundation for managing an online store with features like handling carts, orders, and products.

## Features
- **Entities:** Includes core entities such as `Cart`, `CartItem`, `Order`, `OrderItem`,`user`, `roles` and `Product`, with well-defined relationships.
- **Repository Layer:** Handles database interactions seamlessly.
- **Service Layer:** Contains business logic, ensuring separation of concerns.
- **Controller Layer:** Manages RESTful APIs for HTTP requests, enabling operations like adding items to the cart, placing orders, and more.

## Technologies Used
- **Framework:** Spring Boot  
- **Database:** MySQL (with HikariCP connection pooling)  
- **API Style:** RESTful  

## How to Run
1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd <repository_folder>
Update application.properties with your database configuration.
Build and run the application:
bash
Copy code
./mvnw spring-boot:run
