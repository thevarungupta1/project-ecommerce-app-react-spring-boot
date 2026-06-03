package com.thevarungupta.grocery_app_api.repository;

import com.thevarungupta.grocery_app_api.entity.SubCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByCategoryCatId(Long catId);
}
