package org.java.dojo.oop.fundamentals;

public class Order {
    private final Customer customer;
    private final ShoppingCart shoppingCart;
    private final Payment payment;

    public Order(Customer customer, ShoppingCart shoppingCart, Payment payment) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", shoppingCart=" + shoppingCart +
                ", payment=" + payment +
                '}';
    }
}
