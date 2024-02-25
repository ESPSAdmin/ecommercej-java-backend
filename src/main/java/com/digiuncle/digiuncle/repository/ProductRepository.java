package com.digiuncle.digiuncle.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiuncle.digiuncle.entity.Products;

public interface ProductRepository extends JpaRepository<Products, UUID> {
    // Spring Data JPA will automatically provide implementation for this method
    // It will either insert or update the product based on its state
    // It returns the saved product
    @Override
    public <S extends Products> S save(S products);
}
