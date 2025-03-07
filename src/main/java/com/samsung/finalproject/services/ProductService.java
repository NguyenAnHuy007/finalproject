package com.samsung.finalproject.services;

import com.samsung.finalproject.models.entities.Product;
import com.samsung.finalproject.models.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchProduct(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
