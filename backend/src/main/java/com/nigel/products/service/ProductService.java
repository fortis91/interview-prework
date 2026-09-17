package com.nigel.products.service;

import com.nigel.products.dto.ProductResponse;
import com.nigel.products.model.Product;
import com.nigel.products.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> listProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::from)
                .toList();
    }

    @Transactional
    public ProductResponse createProduct(String name) {
        Product saved = productRepository.save(new Product(name));
        return ProductResponse.from(saved);
    }
}
