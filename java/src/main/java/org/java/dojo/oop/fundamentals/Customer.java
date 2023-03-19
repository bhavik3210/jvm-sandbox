package org.java.dojo.oop.fundamentals;

import java.util.Optional;

public class Customer {

    private final String name;
    private final CreditCard creditCard;

    Customer(String name, CreditCard creditCard) {
        this.name = name;
        this.creditCard = creditCard;
    }

    Optional<Order> checkout(ShoppingCart shoppingCart) {
        Optional<Payment> payment = creditCard.makePayment(shoppingCart.getTotalAmount());
//        return payment.isPresent() ? Optional.of(new Order(this, shoppingCart, payment.get())) : Optional.empty();
        return payment.map(value -> new Order(this, shoppingCart, value));
    }
}
