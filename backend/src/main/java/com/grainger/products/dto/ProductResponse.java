package com.grainger.products.dto;

import com.grainger.products.model.Product;

public record ProductResponse(Long id, String name) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
