package com.citi.product.service;

import com.citi.product.dto.ProductDTO;
import com.citi.product.web.ProductWebClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//AllArgsConstructor can do auto wire
@AllArgsConstructor
public class ProductService {
    private final ProductWebClient webClient;

    public List<ProductDTO> getAllProducts() {
        return webClient.getAllProducts();
    }

    public ProductDTO getProductById(Long id) {
        return webClient.getProductById(id);
    }

    public void createProduct(ProductDTO product) {
        webClient.createProduct(product);
    }

    public void updateProduct(Long id, ProductDTO product) {
        webClient.updateProduct(id, product);
    }

    public void deleteProduct(Long id) {
        webClient.deleteProduct(id);
    }
}
