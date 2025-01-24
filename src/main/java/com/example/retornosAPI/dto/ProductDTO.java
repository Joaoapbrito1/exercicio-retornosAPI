package com.example.retornosAPI.dto;


import jakarta.validation.constraints.*;

public record ProductDTO(
        @NotBlank(message = "O nome do produto é obrigatório.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
        String name,

        @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres.")
        String description,

        @NotNull(message = "O preço é obrigatório.")
        @Positive(message = "O preço deve ser maior que 0.")
        Double price,

        @NotNull(message = "A quantidade em estoque é obrigatória.")
        @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0.")
        Integer stockQuantity,

        @NotBlank(message = "A categoria é obrigatória.")
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