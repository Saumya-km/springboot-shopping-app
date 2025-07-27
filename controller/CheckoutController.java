package com.example.shoppingapp.controller;

import com.example.shoppingapp.model.CartItem;
import com.example.shoppingapp.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @Autowired
    private CartItemRepository cartRepo;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        var items = cartRepo.findAll();
        double total = items.stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();

        model.addAttribute("total", total);
        model.addAttribute("items", items);

        return "checkout";
    }
}
