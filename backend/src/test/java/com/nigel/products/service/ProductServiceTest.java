package com.nigel.products.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.nigel.products.dto.ProductResponse;
import com.nigel.products.model.Product;
import com.nigel.products.repository.ProductRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    void listProductsMapsRepositoryResultsToResponses() {
        given(productRepository.findAll()).willReturn(List.of(new Product("P1"), new Product("P2")));

        List<ProductResponse> result = productService.listProducts();

        assertThat(result).extracting(ProductResponse::name).containsExactly("P1", "P2");
    }

    @Test
    void createProductSavesAndReturnsResponse() {
        given(productRepository.save(any(Product.class))).willReturn(new Product("P1"));

        ProductResponse result = productService.createProduct("P1");

        assertThat(result.name()).isEqualTo("P1");
        verify(productRepository).save(any(Product.class));
    }
}
