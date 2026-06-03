package com.thevarungupta.grocery_app_api.repository;

import com.thevarungupta.grocery_app_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
