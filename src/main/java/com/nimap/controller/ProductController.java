package com.nimap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Product_list;
import com.nimap.service.Product_Services;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private Product_Services productService;

    @GetMapping
    public List<Product_list> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "7") int size) {
        return productService.getAllProducts(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product_list> getProductById(@PathVariable Long id) {
        Product_list product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Product_list createProduct(@RequestBody Product_list product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product_list> updateProduct(@PathVariable Long id, @RequestBody Product_list product) {
        Product_list existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            product.setId(id);
            return ResponseEntity.ok(productService.updateProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product_list existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
