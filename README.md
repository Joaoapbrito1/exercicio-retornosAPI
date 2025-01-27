# Retornos API Documentation

## Overview
This project is a Spring Boot application designed to manage products in an inventory system. It provides a set of APIs for creating, retrieving, updating, deleting, and searching for products. It follows a structured architecture with clear separation of concerns.

## Table of Contents

- [Getting Started](#getting-started)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Endpoints](#endpoints)
- [Models](#models)
- [Validation](#validation)
- [Error Handling](#error-handling)

## Getting Started

### Prerequisites
- Java 17+
- Maven
### Running the Application

```bash
# Clone the repository
git clone <repository-url>

# Navigate to the project directory
cd <project-folder>

# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
```

## Technologies Used

- Spring Boot 3.0
- Spring Data JPA
- Hibernate
- Jakarta Validation

## Project Structure

```
com.example.retornosAPI
|-- controllers
|   \-- ProductController.java
|-- dto
|   \-- ProductDTO.java
|-- exceptions
|   \-- GlobalExceptionHandler.java
|-- models
|   |-- Product.java
|   \-- ProductEntity.java
|-- repositories
|   \-- ProductRepository.java
|-- services
|   \-- ProductService.java
|-- RetornosApiApplication.java
```

## Endpoints

### Product Endpoints

1. **Create Product**
    - **POST** `/api/products`
    - Request Body: `Product`
    - Response: `Product`

2. **Get Product by ID**
    - **GET** `/api/products/{id}`
    - Response: `Product`

3. **Get All Products**
    - **GET** `/api/products`
    - Response: `List<Product>`

4. **Update Product**
    - **PUT** `/api/products/{id}`
    - Request Body: `ProductDTO`
    - Response: `Product`

5. **Delete Product**
    - **DELETE** `/api/products/{id}`
    - Response: No Content

6. **Search Products by Name**
    - **GET** `/api/products/search`
    - Query Parameter: `name`
    - Response: `List<Product>`

## Models

### `ProductEntity`
Represents the database entity for a product.

```java
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private String category;
}
```

### `Product`
Immutable record for API responses.

```java
public record Product(Long id, String name, String description, Double price, Integer stockQuantity, String category){}
```

### `ProductDTO`
Used for creating and updating products.

```java
public record ProductDTO(String name, String description, Double price, Integer stockQuantity, String category){}
```

## Validation

- **Name**: Required, 3-100 characters.
- **Description**: Optional, max 500 characters.
- **Price**: Required, positive.
- **Stock Quantity**: Required, non-negative.
- **Category**: Required, valid values: `Electronics`, `Clothes`, `Food`.

## Error Handling

Global error handling is managed by `GlobalExceptionHandler`:

- **Validation Errors**:
    - Returns `400 Bad Request` with detailed field validation messages.

- **General Errors**:
    - Returns `500 Internal Server Error` with the exception message.

## Contributing

1. Fork the repository.
2. Create your feature branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/my-feature`
5. Open a pull request.

## License
This project is licensed under the MIT License.
