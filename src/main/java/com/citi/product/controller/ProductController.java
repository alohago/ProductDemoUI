package com.citi.product.controller;

import com.citi.product.dto.ProductDTO;
import com.citi.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "view-products";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") ProductDTO product) {
        productService.createProduct(product);
        return "redirect:/";
    }

    @GetMapping("/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "add-product";
    }

    @GetMapping("/edit-product/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        ProductDTO product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/edit-product/{id}")
    public String editProduct(@PathVariable("id") Long id, @ModelAttribute("product") ProductDTO product) {
        productService.updateProduct(id, product);
        return "redirect:/";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
