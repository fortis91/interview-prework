package com.grainger.products.service;

import com.grainger.products.dto.ProductResponse;
import com.grainger.products.model.Product;
import com.grainger.products.repository.ProductRepository;
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
