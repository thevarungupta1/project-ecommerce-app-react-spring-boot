package com.thevarungupta.grocery_app_api.controller;

import com.thevarungupta.grocery_app_api.service.ProductService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/cat/{catId}")
    public Map<String, Object> getProductsByCategory(@PathVariable Long catId) {
        return Map.of("data", productService.getByCategoryId(catId));
    }

    @GetMapping("/{id}")
    public Map<String, Object> getProductById(@PathVariable Long id) {
        return Map.of("data", productService.getById(id));
    }
}
