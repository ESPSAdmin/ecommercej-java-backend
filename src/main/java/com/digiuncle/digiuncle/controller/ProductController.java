package com.digiuncle.digiuncle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiuncle.digiuncle.entity.Products;
import com.digiuncle.digiuncle.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Products products) {
        try {
            // Validate product fields
            if (products.getProduct_name() == null || products.getProduct_MRPprice() <= 0) {
                return ResponseEntity.badRequest().build();
            }
            
            // Add product
            Products addedProduct = productService.addProduct(products);
            
            // Return added product with OK status
            return ResponseEntity.ok(addedProduct);
        } catch (RuntimeException e) {
            // Return error message with BAD_REQUEST status
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
