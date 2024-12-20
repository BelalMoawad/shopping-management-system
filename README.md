E-Commerce Shopping Management System

This project is a shopping management system developed using Spring Boot. It provides a robust foundation for managing an online store with features like handling carts, orders, and products.

Features

Entities: Includes core entities such as Cart, CartItem, Order, OrderItem, and Product, with well-defined relationships.

Architecture: Follows a multi-tier architecture with Repository, Service, and Controller handling different responsibilities.

Layers Overview

Repository Layer

The Repository Layer in Spring Boot is responsible for interacting with the database. It abstracts the data access logic and provides methods to perform CRUD (Create, Read, Update, Delete) operations on entities.

Service Layer

The Service Layer is responsible for business logic. It mediates between the Controller and Repository layers, ensuring that application-specific logic is encapsulated and reusable.

Controller Layer

The Controller Layer handles HTTP requests and acts as the application entry point. It interacts with the Service Layer to process requests and return responses.

Technologies Used

Framework: Spring Boot

Database: MySQL (with HikariCP connection pooling)

API Style: RESTful
