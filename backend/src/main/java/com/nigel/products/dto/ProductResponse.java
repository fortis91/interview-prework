package com.nigel.products.dto;

import com.nigel.products.model.Product;

public record ProductResponse(Long id, String name) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
