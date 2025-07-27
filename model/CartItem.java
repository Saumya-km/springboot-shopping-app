package com.example.shoppingapp.model;

import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;

    // Getters and Setters
}
