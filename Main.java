package com.fawry;

import java.time.LocalDate;

/**
 * Example usage demonstrating the required scenario.
 */
public class Main {
    public static void main(String[] args) {
        // Create products
        Cheese cheese = new Cheese("Cheese", 100, 5, 0.2, LocalDate.now().plusDays(1));
        Biscuits biscuits = new Biscuits("Biscuits", 150, 3, 0.7, LocalDate.now().plusDays(1));

        // Customer with enough balance
        Customer customer = new Customer("John", 10000);

        // Build cart similar to example
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        // Perform checkout
        CheckoutService.checkout(customer, cart);
    }
}