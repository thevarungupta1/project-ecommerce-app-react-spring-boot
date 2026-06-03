package com.thevarungupta.grocery_app_api.service;

import com.thevarungupta.grocery_app_api.dto.CategoryDto;
import com.thevarungupta.grocery_app_api.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDto(category.getCatId(), category.getCatName(), category.getCatImage()))
                .toList();
    }
}
