package org.javalang.collections;


import org.javalang.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts {
    public static void main(String[] args) {
        var door = new Product("Wooden Door", 35);
        var floorPanel = new Product("Floor Panel", 25);
        var window = new Product("Glass Window", 10);

        // Remove products using basic for each loop (which can replaced with removeIf)
        Collection<Product> products = getProducts(door, floorPanel, window);
        products.removeIf(product -> product.weight() > 20);
        System.out.println("For Each " + products);

        // Remove products using Iterator
        Collection<Product> products2 = getProducts(door, floorPanel, window);
        Iterator<Product> it = products2.iterator();
        while (it.hasNext()) {
            var product = it.next();
            if (product.weight() > 20) {
                it.remove();
            }
        }
        System.out.println("Iterator " + products2);

        // Remove using array compare
        Collection<Product> products3 = getProducts(door, floorPanel, window);
        var toRemove = new ArrayList<Product>();
        toRemove.add(door);
        toRemove.add(floorPanel);

        products3.removeAll(toRemove);
        System.out.println("Array Compare " +products3);
    }

    public static Collection<Product> getProducts(Product door, Product floorPanel, Product window) {
        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        return products;
    }
}
