package org.java.dojo.oop.fundamentals;

public class LineItem {

    private final Product product;
    private int quantity;

    LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    int getPrice() {
        return product.getPrice() * quantity;
    }
}
