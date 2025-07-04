# 🛒 Fawry Quantum Internship Challenge 3 – E-Commerce System

## 🚀 Overview
This repository presents my solution for the **Fawry Rise Journey – Full Stack Development Internship Challenge**.

The goal is to design and implement an e-commerce system with the following core functionalities:

---

## 📦 System Requirements

### ✅ Product Types
- Each product has: `name`, `price`, and `quantity`.
- Products may:
  - **Expire** (e.g., Cheese, Biscuits)
  - **Not expire** (e.g., TV, Mobile)
  - **Require shipping** (e.g., Cheese, TV)
  - **Not require shipping** (e.g., Mobile Scratch Cards)
- Shippable products must provide:
  - `getName()` and `getWeight()` (via interface)

---

## 🛍️ Cart Features
- Customers can:
  - Add products with a **specific quantity**, capped by stock.
  - View their cart.
  - Proceed to checkout.

---

## 💳 Checkout Flow
When the customer checks out:

### Console Output Includes:
- **Subtotal** (sum of product prices)
- **Shipping fee**
- **Total paid amount** (subtotal + shipping)
- **Customer balance after payment**

### ❌ Errors are raised if:
- The cart is empty
- Any item is expired or out of stock
- Customer balance is insufficient

### 📦 Shipping Handling
If applicable, collect all shippable items and send them to a `ShippingService` accepting:
```java
interface Shippable {
    String getName();
    double getWeight();
}
