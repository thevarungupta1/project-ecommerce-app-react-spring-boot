package com.thevarungupta.grocery_app_api.service;

import com.thevarungupta.grocery_app_api.dto.ProductDto;
import com.thevarungupta.grocery_app_api.entity.Product;
import com.thevarungupta.grocery_app_api.repository.ProductRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getByCategoryId(Long catId) {
        return productRepository.findByCategoryCatId(catId).stream()
                .map(this::mapToDto)
                .toList();
    }

    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return mapToDto(product);
    }

    private ProductDto mapToDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getImage(),
                product.getDescription(),
                product.getUnit(),
                product.getMrp(),
                product.getPrice()
        );
    }
}
