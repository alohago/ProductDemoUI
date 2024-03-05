package com.citi.product.web;

import com.citi.product.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class ProductWebClient {
    private final WebClient client;

    public ProductWebClient() {
        this.client = WebClient.create("http://localhost:8080");
    }

    public List<ProductDTO> getAllProducts() {
        return client.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(ProductDTO.class)
                .collectList()
                .block();
    }

    public ProductDTO getProductById(Long id) {
        return client.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    public void createProduct(ProductDTO product) {
        client.post()
                .uri("/products")
                .bodyValue(product)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void updateProduct(Long id, ProductDTO product) {
        client.put()
                .uri("/products/{id}", id)
                .bodyValue(product)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void deleteProduct(Long id) {
        client.delete()
                .uri("/products/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
