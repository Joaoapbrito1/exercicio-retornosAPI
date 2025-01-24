package com.example.retornosAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required.")
    @Size(min = 3, max = 100, message = "The name must be between 3 and 100 characters.")
    private String name;

    @Size(max = 500, message = "The description can be a maximum of 500 characters.")
    private String description;

    @NotNull(message = "The price is mandatory.")
    @Positive(message = "Price must be greater than 0.")
    private Double price;

    @NotNull(message = "Quantity in stock is mandatory.")
    @Min(value = 0, message = "The quantity in stock must be greater than or equal to 0.")
    private Integer stockQuantity;

    @NotBlank(message = "The category is mandatory.")
    private String category;

    public ProductEntity() {}

    public ProductEntity(Long id, String name, String description, Double price, Integer stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setStockQuantity(Integer stockQuantity){
        this.stockQuantity = stockQuantity;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public Long getId() {
        return id;
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