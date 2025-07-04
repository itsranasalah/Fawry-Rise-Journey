package com.fawry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Service responsible for shipping items.
 */
public class ShippingService {

    /**
     * Print shipment notice for given shippable items.
     */
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> weights = new LinkedHashMap<>();
        for (Shippable item : items) {
            counts.merge(item.getName(), 1, Integer::sum);
            weights.merge(item.getName(), item.getWeight(), Double::sum);
        }
        double totalWeight = 0.0;
        for (String name : counts.keySet()) {
            int count = counts.get(name);
            double weight = weights.get(name);
            totalWeight += weight;
            System.out.printf("%dx %s %.0fg%n", count, name, weight * 1000);
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}