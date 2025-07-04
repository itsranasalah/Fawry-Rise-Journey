package com.fawry;

import java.time.LocalDate;

/**
 * Cheese is a shippable product that can expire.
 */
public class Cheese extends Product implements Shippable, Expirable {
    private LocalDate expirationDate;
    private double weight; // weight per unit in kg

    public Cheese(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}