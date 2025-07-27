package com.example.shoppingapp.controller;

import com.example.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "products";
    }
}
