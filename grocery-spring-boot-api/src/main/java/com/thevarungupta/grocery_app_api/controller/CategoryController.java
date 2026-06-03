package com.thevarungupta.grocery_app_api.controller;

import com.thevarungupta.grocery_app_api.service.CategoryService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Map<String, Object> getAllCategories() {
        return Map.of("data", categoryService.getAllCategories());
    }
}
