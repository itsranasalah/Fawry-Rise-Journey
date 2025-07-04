package com.fawry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Handles checkout process for a cart.
 */
public class CheckoutService {
    private static final double SHIPPING_PER_ITEM = 10.0; // assumption

    /**
     * Perform checkout for customer with given cart.
     */
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        List<Shippable> toShip = new ArrayList<>();
        double subtotal = 0.0;

        // Validate items
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();

            if (!product.isAvailable(qty)) {
                throw new IllegalStateException(product.getName() + " is out of stock");
            }

            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired");
            }

            subtotal += product.getPrice() * qty;

            if (product instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        double shippingFee = toShip.size() * SHIPPING_PER_ITEM;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Customer's balance is insufficient");
        }

        // Deduct stock and customer balance
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }
        customer.pay(total);

        // Shipment
        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        // Receipt
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            System.out.printf("%dx %s %.0f%n", qty, p.getName(), p.getPrice() * qty);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", total);
        System.out.printf("Balance %.0f%n", customer.getBalance());
        System.out.println("END.");
    }
}