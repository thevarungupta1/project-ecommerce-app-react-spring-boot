package com.thevarungupta.grocery_app_api.controller;

import com.thevarungupta.grocery_app_api.service.SubCategoryService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/{catId}")
    public Map<String, Object> getSubCategoriesByCategory(@PathVariable Long catId) {
        return Map.of("data", subCategoryService.getByCategoryId(catId));
    }
}
