package com.example.retornosAPI.services;

import com.example.retornosAPI.dto.ProductDTO;
import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final List<String> VALID_CATEGORIES = List.of("Electronics", "Clothes", "Food");
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product productDTO) {
        validateCategory(productDTO.category());

        ProductEntity entity = new ProductEntity(
                null,
                productDTO.name(),
                productDTO.description(),
                productDTO.price(),
                productDTO.stockQuantity(),
                productDTO.category()
        );

        return mapToProduct(repository.save(entity));
    }

    public Product getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToProduct(entity);
    }

    public List<Product> getAllProducts() {
        return repository.findAll().stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found for deletion.");
        }
        repository.deleteById(id);
    }
    public Product updateProduct(Long id, ProductDTO productDTO) {
        validateCategory(productDTO.category());

        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        existingEntity.setName(productDTO.name());
        existingEntity.setDescription(productDTO.description());
        existingEntity.setPrice(productDTO.price());
        existingEntity.setStockQuantity(productDTO.stockQuantity());
        existingEntity.setCategory(productDTO.category());

        return mapToProduct(repository.save(existingEntity));
    }
    public List<Product> getProductsByName(String name) {
        List<ProductEntity> entities = repository.findByNameContainingIgnoreCase(name);
        return entities.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }
    private void validateCategory(String category) {
        if (!VALID_CATEGORIES.contains(category)) {
            throw new IllegalArgumentException("The category must be valid: Electronics, Clothing, Food.");
        }
    }
    private Product mapToProduct(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getStockQuantity(),
                entity.getCategory()
        );
    }
}