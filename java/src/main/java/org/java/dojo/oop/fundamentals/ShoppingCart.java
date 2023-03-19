package org.java.dojo.oop.fundamentals;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<LineItem> productsInCart = new ArrayList<>();

    void addLineItem(LineItem lineItem) {
        productsInCart.add(lineItem);
    }

    int getTotalAmount() {
        return productsInCart.stream().mapToInt(LineItem::getPrice).sum();
    }
}
