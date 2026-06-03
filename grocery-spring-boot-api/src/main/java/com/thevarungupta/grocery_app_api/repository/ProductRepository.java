package com.thevarungupta.grocery_app_api.repository;

import com.thevarungupta.grocery_app_api.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryCatId(Long catId);
}
