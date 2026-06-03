package com.thevarungupta.grocery_app_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public record ProductDto(
        @JsonProperty("_id") Long id,
        String productName,
        String image,
        String description,
        String unit,
        BigDecimal mrp,
        BigDecimal price
) {
}
