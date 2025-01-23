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

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres.")
    private String description;

    @NotNull(message = "O preço é obrigatório.")
    @Positive(message = "O preço deve ser maior que 0.")
    private Double price;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0.")
    private Integer stockQuantity;

    @NotBlank(message = "A categoria é obrigatória.")
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