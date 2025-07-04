package com.fawry;

/**
 * Marker interface for shippable products.
 * Provides name and weight per item.
 */
public interface Shippable {
    String getName();
    double getWeight(); // weight per unit in kilograms
}