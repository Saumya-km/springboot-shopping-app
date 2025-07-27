package com.example.shoppingapp.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;

    // Getters and Setters
}
