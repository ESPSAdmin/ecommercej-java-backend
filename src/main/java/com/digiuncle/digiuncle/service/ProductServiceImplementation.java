package com.digiuncle.digiuncle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiuncle.digiuncle.entity.Products;
import com.digiuncle.digiuncle.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Products addProduct(Products products) {
        return productRepository.save(products);
    }
}
