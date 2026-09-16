package com.grainger.products.product;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(@NotBlank String name) {
}
