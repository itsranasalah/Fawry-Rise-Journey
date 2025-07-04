package com.fawry;

/**
 * TV is a shippable product with no expiry.
 */
public class TV extends Product implements Shippable {
    private double weight; // weight per unit in kg

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}