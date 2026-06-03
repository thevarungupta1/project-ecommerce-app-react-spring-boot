package com.thevarungupta.grocery_app_api.service;

import com.thevarungupta.grocery_app_api.dto.SubCategoryDto;
import com.thevarungupta.grocery_app_api.repository.SubCategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategoryDto> getByCategoryId(Long catId) {
        return subCategoryRepository.findByCategoryCatId(catId).stream()
                .map(subCategory -> new SubCategoryDto(subCategory.getSubId(), subCategory.getSubName()))
                .toList();
    }
}
