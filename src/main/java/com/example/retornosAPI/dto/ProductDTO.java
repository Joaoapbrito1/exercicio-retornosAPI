package com.example.retornosAPI.dto;


import jakarta.validation.constraints.*;

public record ProductDTO(
        @NotBlank(message = "Product name is required.")
        @Size(min = 3, max = 100, message = "The name must be between 3 and 100 characters.")
        String name,

        @Size(max = 500, message = "The description can be a maximum of 500 characters.")
        String description,

        @NotNull(message = "The price is mandatory.")
        @Positive(message = "Price must be greater than 0.")
        Double price,

        @NotNull(message = "Quantity in stock is mandatory.")
        @Min(value = 0, message = "The quantity in stock must be greater than or equal to 0.")
        Integer stockQuantity,

        @NotBlank(message = "The category is mandatory.")
        String category){

    public ProductDTO(String name, String description, Double price, Integer stockQuantity, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
    public Integer getStockQuantity(){
        return stockQuantity;
    }
    public String getCategory(){
        return category;
    }
}