package com.example.shoppingapp.controller;

import com.example.shoppingapp.model.CartItem;
import com.example.shoppingapp.model.Product;
import com.example.shoppingapp.repository.CartItemRepository;
import com.example.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId) {
        Product product = productRepo.findById(productId).orElse(null);
        if (product == null) return "redirect:/products";

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(1);

        cartRepo.save(item);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(org.springframework.ui.Model model) {
        model.addAttribute("cartItems", cartRepo.findAll());
        return "cart";
    }
}
